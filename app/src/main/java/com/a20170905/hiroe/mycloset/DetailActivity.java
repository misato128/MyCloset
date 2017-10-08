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
import java.io.IOException;
/**
 * Created by Misato on 2017/10/07.
 */
public class DetailActivity extends AppCompatActivity {
    private ImageView colorView;
    private ImageView seasonView;
    private ImageView categoryView;
    private Button SaveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        Intent intent = getIntent();
        Uri imageUri = intent.getData();
        ImageView imageView = (ImageView)findViewById(R.id.image_view);
        imageView.setImageURI(imageUri);

        TextView textView = (TextView) findViewById(R.id.text_view_date);
        String path = "aaaaaaaaaaaaaaaaaaaaaa";
        String date = getImageDateInDiary(path);
        textView.setText("購入日時：" + date);
        TextView textView3 = (TextView) findViewById(R.id.text_view_brand);
        String brand = " ";
        textView3.setText("ブランド：" + brand);
        colorView = (ImageView) findViewById(R.id.color_view);
        colorView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectColorActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        seasonView = (ImageView) findViewById(R.id.season_view);
        seasonView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),SelectSeasonActivity.class);
                startActivityForResult(intent, 2);
            }
        });
        categoryView = (ImageView) findViewById(R.id.category_view);
        categoryView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),SelectCategoryActivity.class);
                startActivityForResult(intent,3);
            }
        });
        SaveButton = (Button) findViewById(R.id.save_button);
        SaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data.getExtras().getString("SELECT_COLOR").equals("white")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_white);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("yellow")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_yellow);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("orange")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_orange);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("red")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_red);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("pink")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_pink);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("brown")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_brown);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("black")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_black);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("gray")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_gray);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("blue")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_blue);
            } else if (data.getExtras().getString("SELECT_COLOR").equals("green")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_green);
            }
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
            if (data.getExtras().getString("SELECT_SEASON").equals("spring")) {
                seasonView.setImageResource(R.mipmap.spring);
            } else if (data.getExtras().getString("SELECT_SEASON").equals("summer")) {
                seasonView.setImageResource(R.mipmap.summer);
            } else if (data.getExtras().getString("SELECT_SEASON").equals("autumn")) {
                seasonView.setImageResource(R.mipmap.autumn);
            } else if (data.getExtras().getString("SELECT_SEASON").equals("winter")) {
                seasonView.setImageResource(R.mipmap.winter);
            }
        }
        if (requestCode == 3 && resultCode == RESULT_OK) {
            if (data.getExtras().getString("SELECT_CATEGORY").equals("tops")) {
                categoryView.setImageResource(R.mipmap.ic_tops);
            } else if (data.getExtras().getString("SELECT_CATEGORY").equals("bottoms")) {
                categoryView.setImageResource(R.mipmap.ic_bottoms);
            } else if (data.getExtras().getString("SELECT_CATEGORY").equals("outer")) {
                categoryView.setImageResource(R.mipmap.ic_outer);
            } else if (data.getExtras().getString("SELECT_CATEGORY").equals("shoes")) {
                categoryView.setImageResource(R.mipmap.ic_shoes);
            }
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