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

public class SelectSeasonActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_imput_season_select);

        findViewById(R.id.spring).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_SEASON", "spring");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.summer).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_SEASON", "summer");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.autumn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_SEASON", "autumn");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.winter).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_SEASON", "winter");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}