package org.jyy.lpython_android.fragment;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jyy.lpython_android.R;

/**
 * Created by yangyang on 2018/1/16.
 */

public abstract  class BaseFragment extends Fragment {
    protected View contentView;
    private static final String TAG = "BaseFragment";
    protected Activity mActivity;



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;

    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(contentView==null){
            contentView=inflater.inflate(setContentView(), null);
            initView();
        }else{
            ViewGroup parent = (ViewGroup) contentView.getParent();
            if (parent != null){
                parent.removeView(contentView);
            }
        }
        return contentView;

    }
    /*
     * 子类最好重载，对代码的封装
     */
    protected abstract void initView() ;
    /*
     * 加载布局文件
     */
    protected abstract int setContentView();

    /*
     * 加载布局文件
     */
    protected View setContentView(LayoutInflater inflater, int resId) {
        return contentView = inflater.inflate(resId, null);
    }

    /*
     * 加载布局文件完后找到一个view对象
     */
    protected View findViewById(int resId) {
        return contentView.findViewById(resId);
    }
}
