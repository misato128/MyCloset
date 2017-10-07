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

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by hiroe on 2017/10/07.
 */

public class RecyclerShoesFragment extends Fragment implements OnRecyclerListener {
    private View mView;
    private RecyclerFragmentListener mFragmentListener = null;

    // RecyclerViewとAdapter
    private RecyclerView mRecyclerViewShoes = null;
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
        mView = inflater.inflate(R.layout.fragment_item_list_shoes, container, false);

        // RecyclerViewの参照を取得
        mRecyclerViewShoes = (RecyclerView) mView.findViewById(R.id.recycler_view_shoes);

        LinearLayoutManager managerShoes = new LinearLayoutManager(getContext());
        managerShoes.setOrientation(LinearLayoutManager.HORIZONTAL); // ここで横方向に設定

        mRecyclerViewShoes.setLayoutManager(managerShoes);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 適当にデータ作成
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<Wear> wears = realm.where(Wear.class).equalTo("category", "shoes").findAll();
        int realmSize = wears.size();
        ArrayList<Integer> shoesArray = new ArrayList<>();
        for(int i = 0; i < realmSize; i++){
            shoesArray.add(wears.get(i).getId());

        }
        realm.close();

        mAdapterShoes = new RecyclerAdapter(getContext(), shoesArray, this);

        mRecyclerViewShoes.setAdapter(mAdapterShoes);

    }
}