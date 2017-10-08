package com.a20170905.hiroe.mycloset;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Tomoya on 2017/10/08.
 */

public class TimelineFragment  extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, null);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragment_timeline_linearlayout);
        return view;
    }
}