package com.a20170905.hiroe.mycloset;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import io.realm.Realm;

public class DetailActivity extends AppCompatActivity {
    private ImageView colorView;
    private ImageView seasonView;
    private ImageView categoryView;
    private Button SaveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        colorView = (ImageView) findViewById(R.id.color_view);
        seasonView = (ImageView) findViewById(R.id.season_view);
        categoryView = (ImageView) findViewById(R.id.category_view);
        colorView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectColorActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        seasonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSeasonActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        categoryView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectColorActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        Intent intent = getIntent();
        Uri imageUri = intent.getData();

        if (imageUri == null){
            int id = intent.getIntExtra("com.a20170905.hiroe.mycloset.intent.id", 0);
            Toast.makeText(this, ""+id, Toast.LENGTH_LONG).show();
            Realm realm = Realm.getDefaultInstance();
            final Wear wear = realm.where(Wear.class).equalTo("id", id).findFirst();
            ImageView imageView = (ImageView)findViewById(R.id.image_view);
            imageView.setImageURI(Uri.parse(wear.getImagePath()));

            TextView textview = (TextView) findViewById(R.id.text_view_date);
            textview.setText("購入日時：" + wear.getBoughtAt());

            TextView textView3 = (TextView) findViewById(R.id.text_view_brand);
            textView3.setText("ブランド：" + wear.getShopName());

            colorView.setImageResource(colorStringToInt(wear.getColor()));

            seasonView.setImageResource(seasonStringToInt(wear.getSeason()));

            categoryView.setImageResource(categoryStringToInt(wear.getCategory()));

            realm.close();
        }
        else {
            ImageView imageView = (ImageView)findViewById(R.id.image_view);
            imageView.setImageURI(imageUri);

            TextView textView = (TextView) findViewById(R.id.text_view_date);
            String date = "2017/10/01";
            textView.setText("購入日時：" + date);

            TextView textView3 = (TextView) findViewById(R.id.text_view_brand);
            String brand = " ";
            textView3.setText("ブランド：" + brand);
        }
    }

    private int colorStringToInt(String colorName) {
        if(colorName.equals("white")) {
            return R.drawable.ic_circle_icon_white;
        }
        else if (colorName.equals("yellow")) {
            return R.drawable.ic_circle_icon_yellow;
        }
        else if (colorName.equals("orange")) {
            return R.drawable.ic_circle_icon_orange;
        }
        else if (colorName.equals("red")) {
            return R.drawable.ic_circle_icon_red;
        }
        else if (colorName.equals("pink")) {
            return R.drawable.ic_circle_icon_pink;
        }
        else if (colorName.equals("brown")) {
            return R.drawable.ic_circle_icon_brown;
        }
        else if (colorName.equals("black")) {
            return R.drawable.ic_circle_icon_black;
        }
        else if (colorName.equals("gray")) {
            return R.drawable.ic_circle_icon_gray;
        }
        else if (colorName.equals("blue")) {
            return R.drawable.ic_circle_icon_blue;
        }
        else if (colorName.equals("green")) {
            return R.drawable.ic_circle_icon_green;
        } else {
            return -1;
        }
    }

    private int seasonStringToInt(String season){
        if (season.equals("spring")) {
            return R.mipmap.ic_spring;
        } else if (season.equals("summer")) {
            return R.mipmap.ic_summer;
        } else if (season.equals("autumn")) {
            return R.mipmap.ic_autumn;
        } else if (season.equals("winter")) {
            return R.mipmap.ic_winter;
        } else {
            return -1;
        }
    }

    private int categoryStringToInt(String category){
        if (category.equals("tops")) {
            return R.mipmap.ic_tops;
        } else if (category.equals("bottoms")) {
            return R.mipmap.ic_bottoms;
        } else if (category.equals("outer")) {
            return R.mipmap.ic_outer;
        } else if (category.equals("shoes")) {
            return R.mipmap.ic_shoes;
        } else {
            return -1;
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            colorView.setImageResource(colorStringToInt(data.getExtras().getString("SELECT_COLOR")));
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
            seasonView.setImageResource(seasonStringToInt(data.getExtras().getString("SELECT_SEASON")));
        }
        if (requestCode == 3 && resultCode == RESULT_OK) {
            categoryView.setImageResource(categoryStringToInt(data.getExtras().getString("SELECT_CATEGORY")));
        }
    }
    public String getImageDateInDiary(String path) {
        String result = "";
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            result = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
        } catch (IOException e) {
            e.printStackTrace();
            result = "日時不明";
        }
        if (result != null && result.length() > 16) {
            result = result.substring(0, 4) + "/" + result.substring(5, 7)
                    + "/" + result.substring(8, 10) + " "
                    + result.substring(11, 13) + ":" + result.substring(14, 16);
        } else {
            result = "日時不明";
        }
        return result;
    }
}