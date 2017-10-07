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

public class SelectColorActivity extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_imput_color_select);

        findViewById(R.id.white).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "white");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.yellow).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "yellow");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.orange).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "orange");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.red).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "red");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.pink).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "pink");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.brown).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "brown");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.black).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "black");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.gray).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "gray");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.blue).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "blue");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.green).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SELECT_COLOR", "green");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
