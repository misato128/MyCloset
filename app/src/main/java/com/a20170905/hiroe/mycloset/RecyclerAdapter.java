package com.a20170905.hiroe.mycloset;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by hiroe on 2017/10/07.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Integer> mData;
    private Context mContext;
    private OnRecyclerListener mListener;

    public RecyclerAdapter(Context context, ArrayList<Integer> data, OnRecyclerListener listener) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
        mListener = listener;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 表示するレイアウトを設定
        return new ViewHolder(mInflater.inflate(R.layout.list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        // データ表示
        if (mData != null && mData.size() > i && mData.get(i) != null) {
            Realm realm = Realm.getDefaultInstance();
            String imagePath = realm.where(Wear.class).equalTo("id", mData.get(i)).findFirst().getImagePath();

            //String imagePath = "/storage/emulated/0/Pictures/1507387715452.jpg";
            File file = new File(imagePath);
            Uri uri = Uri.fromFile(file);
            viewHolder.imageView.setImageURI(uri);
            realm.close();
        }

        // クリック処理
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRecyclerClicked(v, i);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        } else {
            return 0;
        }
    }

    // ViewHolder(固有ならインナークラスでOK)
    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.list_item_image);
        }
    }

}
