package com.a20170905.hiroe.mycloset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Misato on 2017/10/07.
 */

public class SelectCategoryActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_imput_category_select);

        findViewById(R.id.tops).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_CATEGORY", "tops");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.bottoms).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_CATEGORY", "bottoms");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.outer).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_CATEGORY", "outer");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.shoes).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_CATEGORY", "shoes");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}