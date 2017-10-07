package com.a20170905.hiroe.mycloset;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class DetailActivity extends AppCompatActivity {
    private ImageView colorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        Intent intent = getIntent();
        Uri imageUri = intent.getData();
        ImageView imageView = (ImageView)findViewById(R.id.image_view);
        imageView.setImageURI(imageUri);

        TextView textView = (TextView) findViewById(R.id.text_view_date);
        String date = "2017/10/01";
        textView.setText("購入日時：" + date);

        TextView textView3 = (TextView) findViewById(R.id.text_view_brand);
        String brand = "ユニクロ";
        textView3.setText("ブランド：" + brand);

        colorView = (ImageView) findViewById(R.id.color_view);
        colorView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectColorActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if(data.getExtras().getString("SELECT_COLOR").equals("white")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_white);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("yellow")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_yellow);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("orange")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_orange);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("red")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_red);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("pink")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_pink);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("brown")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_brown);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("black")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_black);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("gray")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_gray);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("blue")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_blue);
            }
            else if (data.getExtras().getString("SELECT_COLOR").equals("green")) {
                colorView.setImageResource(R.drawable.ic_circle_icon_green);
            }
        }
    }


}
