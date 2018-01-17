package org.jyy.lpython_android.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import org.jyy.lpython_android.Entity.TabEntity;
import org.jyy.lpython_android.R;

import java.util.ArrayList;



public class FragmentArticle extends Fragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private CommonTabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] mTitles = {"伯乐在线", "简书", "头条", "微信"};
    public static Activity activity;
    public static FragmentManager mfragmentManager;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    protected View rootView;


    public static FragmentArticle newInstance(Activity mActivity ,FragmentManager fragmentManager){
        FragmentArticle fragment = new FragmentArticle();
        mfragmentManager = fragmentManager;
        activity = mActivity;

        return fragment;
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(rootView==null){
            rootView=inflater.inflate(R.layout.article_fragment, null);
            initView(rootView);

        }else{
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null){
                parent.removeView(rootView);
            }
        }
        return rootView;

    }

    protected void initView(View view) {
        mFragments.add(FragmentArticle_Joble.newInstance());
        mFragments.add(FragmentArticle_JianShu.newInstance());
        mFragments.add(FragmentArticle_TouTiao.newInstance());
        mFragments.add(FragmentArticle_TouTiao.newInstance());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i],0,0));
        }
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(mfragmentManager));
        /** indicator圆角色块 */
        mTabLayout = (CommonTabLayout)view.findViewById(R.id.topPanel);
        mTabLayout.setTabData(mTabEntities);

        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Log.i("FragmentArticle","FragmentArticle"+"执行完毕");
    }



    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    protected int dp2px(float dp) {
        final float scale = activity.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }



}
