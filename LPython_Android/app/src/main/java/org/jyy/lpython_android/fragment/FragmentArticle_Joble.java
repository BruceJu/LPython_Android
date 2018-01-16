package org.jyy.lpython_android.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.mikepenz.itemanimators.ScaleUpAnimator;
import com.mikepenz.itemanimators.SlideInOutRightAnimator;

import org.jyy.lpython_android.Adapter.MyRecyclerViewAdapter;
import org.jyy.lpython_android.R;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;


public class FragmentArticle_Joble extends Fragment {
    protected View rootView;
    protected RecyclerView mRecyclerView;
    protected MaterialRefreshLayout materialRefreshLayout;
    protected List<Integer> datas;
    protected MyRecyclerViewAdapter mRecyclerViewAdapter;



    public static FragmentArticle_Joble newInstance(){
        FragmentArticle_Joble fragment = new FragmentArticle_Joble();
        return fragment;
    }


    public FragmentArticle_Joble() {

    }


    public void Refresh() {
        final long timeInterval = 3000;
        Runnable runnable = new Runnable() {
            public void run() {
                {
                    System.out.println("execute task");
                    try {
                        Thread.sleep(timeInterval);
                        datas.clear();
                        for (int i = 0; i < 50; i++) {
                            datas.add(i);
                        }
                        materialRefreshLayout.finishRefresh();
                        mRecyclerViewAdapter.notifyDataSetChanged();


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void RefreshMore() {
        final long timeInterval = 2000;
        Runnable runnable = new Runnable() {
            public void run() {
                {
                    System.out.println("execute task");
                    try {
                        Thread.sleep(timeInterval);
                        for (int i = 0; i < 50; i++) {
                            datas.add(i);
                        }
                        materialRefreshLayout.finishRefreshLoadMore();
                        mRecyclerViewAdapter.notifyDataSetChanged();


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
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
    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new SlideInOutRightAnimator(mRecyclerView));
        datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add(i);
        }
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        materialRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.refresh_layout);
        materialRefreshLayout.setWaveColor(0xffffffff);
        materialRefreshLayout.setIsOverLay(false);
        materialRefreshLayout.setWaveShow(true);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                Refresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                RefreshMore();
            }
        });

    }
}