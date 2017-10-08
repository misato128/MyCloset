package com.a20170905.hiroe.mycloset;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Uri m_uri;
    private static final int REQUEST_CHOOSER = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this).build());
        setupRealm();
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        MainFragmentAdapter adapter = new MainFragmentAdapter(manager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                showGallery();
            }
        });
    }

    private void setupRealm() {
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<Wear> wears = realm.allObjects(Wear.class);
        if (wears.size() < 10) {
            try {
                // add data
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        int ct = 0;
                        String[] paths = {"/storage/emulated/0/Pictures/1507387564412.jpg", "/storage/emulated/0/Pictures/1507387715452.jpg",
                                "/storage/emulated/0/Pictures/1507387784316.jpg", "/storage/emulated/0/Pictures/1507387850606.jpg",
                                "/storage/emulated/0/Pictures/1507387876877.jpg", "/storage/emulated/0/Pictures/1507387994474.jpg",
                                "/storage/emulated/0/Pictures/1507388073290.jpg", "/storage/emulated/0/Pictures/1507388073290.jpg",
                                "/storage/emulated/0/Pictures/1507388182634.jpg", "/storage/emulated/0/Pictures/1507388257192.jpg"};
                        String[] seasons = {"spring", "summer", "autumn", "winter", "spring", "summer", "autumn", "winter", "autumn", "winter"};
                        String[] colors = {"black", "red", "blue", "green", "white", "black", "red", "blue", "green", "white"};
                        String[] dates = {"2016/10/01", "2017/05/01", "2015/01/20", "2016/10/01", "2017/05/01", "2015/01/20", "2016/10/01", "2017/05/01", "2015/01/20", "2016/11/23"};
                        String[] shopNames = {"ユニクロ", "gu", "ユニクロ", "gu", "ユニクロ", "gu", "ユニクロ", "gu", "ユニクロ", "gu"};
                        int[] rates = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
                        String[] categories = {"bottoms", "tops", "bottoms", "tops", "bottoms", "tops", "bottoms", "tops", "shoes", "outer"};
                        while(true){
                            if(realm.where(Wear.class).equalTo("imagePath", paths[ct]).findFirst() == null){
                                realm.copyToRealm(new Wear(ct+1, paths[ct], seasons[ct], colors[ct], dates[ct], shopNames[ct], rates[ct], categories[ct]));
                            }
                            ct++;
                            if (ct == 10) {
                                break;
                            }
                        }
                        /*realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507387564412.jpg", "spring", "black", "2016/10/01", "ユニクロ", 3, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507387715452.jpg", "summer", "red", "2016/10/07", "gu", 2, "tops"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507387784316.jpg", "autumn", "green", "2017/10/01", "ユニクロ", 3, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507387850606.jpg", "summer", "black", "2015/11/21", "ユニクロ", 3, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507387876877.jpg", "spring", "black", "2016/04/30", "ユニクロ", 3, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507387994474.jpg", "summer", "black", "2017/05/01", "gu", 1, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507388073290.jpg", "summer", "black", "2016/10/01", "ユニクロ", 2, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507388127689.jpg", "winter", "black", "2015/08/16", "ユニクロ", 3, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507388182634.jpg", "autumn", "black", "2016/07/01", "ユニクロ", 1, "bottoms"));
                        realm.copyToRealm(new Wear("/storage/emulated/0/Pictures/1507388257192.jpg", "winter", "black", "2016/10/18", "ユニクロ", 3, "bottoms"));
                    */
                    }
                });
            }finally {
                // getしたらcloseする
                realm.close();
            }
        }
    }

    /* added by Ka, maybe delete it later

    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClassName("com.a20170905.hiroe.mycloset.Main.intent","com.a20170905.hiroe.mycloset.Main.intent.DetailActivity");
        intent.putExtra("com.a20170905.hiroe.mycloset.Main.intent.testString", "!TEST STRING!");

        startActivity(intent);
    }*/

    private void showGallery() {

        //カメラの起動Intentの用意
        String photoName = System.currentTimeMillis() + ".jpg";
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE, photoName);
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        m_uri = getContentResolver()
                .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, m_uri);

        // ギャラリー用のIntent作成
        Intent intentGallery;
        if (Build.VERSION.SDK_INT < 19) {
            intentGallery = new Intent(Intent.ACTION_GET_CONTENT);
            intentGallery.setType("image/*");
        } else {
            intentGallery = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intentGallery.addCategory(Intent.CATEGORY_OPENABLE);
            intentGallery.setType("image/jpeg");
        }
        Intent intent = Intent.createChooser(intentCamera, "画像の選択");
        intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {intentGallery});
        startActivityForResult(intent, REQUEST_CHOOSER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CHOOSER) {

            if(resultCode != RESULT_OK) {
                // キャンセル時
                return ;
            }

            Uri resultUri = (data != null ? data.getData() : m_uri);

            if(resultUri == null) {
                // 取得失敗
                return;
            }

            // ギャラリーへスキャンを促す
            MediaScannerConnection.scanFile(
                    this,
                    new String[]{resultUri.getPath()},
                    new String[]{"image/jpeg"},
                    null
            );

            // 画像を設定
            Intent intent = new Intent();
            intent.setClassName("com.a20170905.hiroe.mycloset","com.a20170905.hiroe.mycloset.DetailActivity");
            intent.setData(resultUri);
            startActivity(intent);

        }

    }
}
