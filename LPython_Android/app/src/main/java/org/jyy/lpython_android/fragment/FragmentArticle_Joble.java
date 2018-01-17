package org.jyy.lpython_android.fragment;

import android.content.Context;
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
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

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
        int resId = R.anim.layout_animation_from_right ;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
        mRecyclerView.setLayoutAnimation(animation);
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add(i);
        }
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        materialRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.refresh_layout);
        materialRefreshLayout.setWaveColor(0xff3300);
        materialRefreshLayout.setIsOverLay(true);
        materialRefreshLayout.setWaveShow(true);
        materialRefreshLayout.setLoadMore(true);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                Handler handler =new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.clear();
                        for (int i = 0; i < 10; i++) {
                            datas.add(i);
                        }
                        mRecyclerViewAdapter.notifyDataSetChanged();
                        runLayoutAnimation(mRecyclerView);
                        materialRefreshLayout.finishRefresh();
                    }
                }, 3000);
            }

            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                Handler handler =new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            datas.add(i);
                        }
                        mRecyclerViewAdapter.notifyDataSetChanged();
                        runLayoutAnimation(mRecyclerView);
                        materialRefreshLayout.finishRefreshLoadMore();
                    }
                }, 3000);
            }
        });

    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_right);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}