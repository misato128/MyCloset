package com.a20170905.hiroe.mycloset;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by hiroe on 2017/10/07.
 */

public class RecyclerFragment extends Fragment implements OnRecyclerListener {
    private View mView;
    private RecyclerFragmentListener mFragmentListener = null;

    // RecyclerViewとAdapter
    private RecyclerView mRecyclerViewTops = null;
    private RecyclerView mRecyclerViewBottoms = null;
    private RecyclerView mRecyclerViewOuter = null;
    private RecyclerView mRecyclerViewShoes = null;
    private RecyclerAdapter mAdapterTops = null;
    private RecyclerAdapter mAdapterBottoms = null;
    private RecyclerAdapter mAdapterOuter = null;
    private RecyclerAdapter mAdapterShoes = null;

    @Override
    public void onRecyclerClicked(View v, int position) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public interface RecyclerFragmentListener {
        void onRecyclerEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_item_list, container, false);

        // RecyclerViewの参照を取得
        mRecyclerViewTops = (RecyclerView) mView.findViewById(R.id.recycler_view_tops);
        mRecyclerViewBottoms = (RecyclerView) mView.findViewById(R.id.recycler_view_bottoms);
        mRecyclerViewOuter = (RecyclerView) mView.findViewById(R.id.recycler_view_outer);
        mRecyclerViewShoes = (RecyclerView) mView.findViewById(R.id.recycler_view_shoes);

        LinearLayoutManager managerTops = new LinearLayoutManager(getContext());
        managerTops.setOrientation(LinearLayoutManager.HORIZONTAL); // ここで横方向に設定

        LinearLayoutManager managerBottoms = new LinearLayoutManager(getContext());
        managerBottoms.setOrientation(LinearLayoutManager.HORIZONTAL); // ここで横方向に設定

        LinearLayoutManager managerOuter = new LinearLayoutManager(getContext());
        managerOuter.setOrientation(LinearLayoutManager.HORIZONTAL); // ここで横方向に設定

        LinearLayoutManager managerShoes = new LinearLayoutManager(getContext());
        managerShoes.setOrientation(LinearLayoutManager.HORIZONTAL); // ここで横方向に設定
        mRecyclerViewTops.setLayoutManager(managerTops);
        mRecyclerViewBottoms.setLayoutManager(managerBottoms);
        mRecyclerViewOuter.setLayoutManager(managerOuter);
        mRecyclerViewShoes.setLayoutManager(managerShoes);



        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 適当にデータ作成
        ArrayList<String> array = new ArrayList<>();
        array.add("トップス");
        array.add("B");
        array.add("C");



        mAdapterTops = new RecyclerAdapter(getContext(), images, this);
        mAdapterBottoms = new RecyclerAdapter(getContext(), array, this);
        mAdapterOuter = new RecyclerAdapter(getContext(), array, this);
        mAdapterShoes = new RecyclerAdapter(getContext(), array, this);


        mRecyclerViewTops.setAdapter(mAdapterTops);
        mRecyclerViewBottoms.setAdapter(mAdapterBottoms);
        mRecyclerViewOuter.setAdapter(mAdapterOuter);
        mRecyclerViewShoes.setAdapter(mAdapterShoes);
    }
}