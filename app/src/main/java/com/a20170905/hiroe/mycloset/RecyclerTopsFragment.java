package com.a20170905.hiroe.mycloset;

import android.content.Context;
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

public class RecyclerTopsFragment extends Fragment implements OnRecyclerListener {
    private View mView;
    private RecyclerFragmentListener mFragmentListener = null;

    // RecyclerViewとAdapter
    private RecyclerView mRecyclerViewTops = null;
    private RecyclerAdapter mAdapterTops = null;

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
        mView = inflater.inflate(R.layout.fragment_item_list_tops, container, false);

        // RecyclerViewの参照を取得
        mRecyclerViewTops = (RecyclerView) mView.findViewById(R.id.recycler_view_tops);

        LinearLayoutManager managerTops = new LinearLayoutManager(getContext());
        managerTops.setOrientation(LinearLayoutManager.HORIZONTAL); // ここで横方向に設定

        mRecyclerViewTops.setLayoutManager(managerTops);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 適当にデータ作成
        ArrayList<Integer> topsArray = new ArrayList<>();
        topsArray.add(R.drawable.brown_top);
        topsArray.add(R.drawable.white_top);
        topsArray.add(R.drawable.black_bottom);

        mAdapterTops = new RecyclerAdapter(getContext(), topsArray, this);

        mRecyclerViewTops.setAdapter(mAdapterTops);

    }
}