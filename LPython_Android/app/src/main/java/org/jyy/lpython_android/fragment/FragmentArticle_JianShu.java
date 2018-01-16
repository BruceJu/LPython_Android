package org.jyy.lpython_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jyy.lpython_android.Adapter.MyRecyclerViewAdapter;
import org.jyy.lpython_android.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentArticle_JianShu extends Fragment {
    protected View rootView;

    public static FragmentArticle_JianShu newInstance(){
        FragmentArticle_JianShu fragment = new FragmentArticle_JianShu();
        return fragment;
    }


    public FragmentArticle_JianShu() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(R.layout.artcle_fragment_joble, null);
            initView(rootView);
        }else{
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null){
                parent.removeView(rootView);
            }
        }
        return rootView;
    }
    private void initView(View view){
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), datas));
    }
}