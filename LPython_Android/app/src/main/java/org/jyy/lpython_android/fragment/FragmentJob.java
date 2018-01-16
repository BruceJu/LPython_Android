package org.jyy.lpython_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jyy.lpython_android.Constants;
import org.jyy.lpython_android.R;



public class FragmentJob extends Fragment {

    public static FragmentJob newInstance(){
        FragmentJob fragment = new FragmentJob();
        return fragment;
    }


    public FragmentJob() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.job_fragment, container, false);
        return view;
    }
}