package org.jyy.lpython_android.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.jyy.lpython_android.R;


public class SimpleCardFragment extends Fragment {


    public static SimpleCardFragment newInstance(String param1) {
        SimpleCardFragment fragment = new SimpleCardFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public SimpleCardFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_simple_card, container, false);
        TextView tv=(TextView)view.findViewById(R.id.card_title_tv);
        tv.setText("正在开发敬请期待");
        return view;
    }

}