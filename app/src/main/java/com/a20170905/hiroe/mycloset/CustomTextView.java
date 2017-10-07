package com.a20170905.hiroe.mycloset;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hiroe on 2017/10/07.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    private String mFont = "mini-wakuwaku-maru.otf";

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        getFont(context, attrs);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getFont(context, attrs);
        init();
    }

    public CustomTextView(Context context) {
        super(context);
        init();
    }

    /**
     * フォントファイルを読み込む
     *
     * @param context
     * @param attrs
     */
    private void getFont(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        mFont = a.getString(R.styleable.CustomTextView_font);
        a.recycle();
    }

    /**
     * フォントを反映
     */
    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), mFont);
        setTypeface(tf);
    }
}

