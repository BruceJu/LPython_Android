package org.jyy.lpython_android.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.jyy.lpython_android.R;
import org.jyy.lpython_android.fragment.FragmentArticle;
import org.jyy.lpython_android.fragment.FragmentJob;
import org.jyy.lpython_android.fragment.FragmentVideo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar mBottomNavigationBar;

    private FragmentArticle mFragmentArticle;

    private FragmentJob mFragmentJob;

    private FragmentVideo mFragmentVideo;

    private FragmentManager mFragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar.setBarBackgroundColor(R.color.white);//set background color for navigation bar
        mBottomNavigationBar.setInActiveColor(R.color.white);//unSelected icon color
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.tab_contact_select, R.string.tab_article).setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.tab_more_select, R.string.tab_video).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.tab_speech_select, R.string.tab_job).setActiveColorResource(R.color.lime))
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * set the default fragment
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mFragmentArticle = FragmentArticle.newInstance(this,getSupportFragmentManager());
        transaction.replace(R.id.ll_content, mFragmentArticle).commit();
    }

    @Override
    public void onTabSelected(int position) {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentArticle == null) {
                    mFragmentArticle = FragmentArticle.newInstance(this,mFragmentManager);
                }

                transaction.replace(R.id.ll_content, mFragmentArticle);
                break;
            case 1:
                if (mFragmentJob == null) {
                    mFragmentJob = FragmentJob.newInstance();
                }

                transaction.replace(R.id.ll_content, mFragmentJob);
                break;
            case 2:
                if (mFragmentVideo == null) {
                    mFragmentVideo = FragmentVideo.newInstance();
                }

                transaction.replace(R.id.ll_content, mFragmentVideo);
                break;
            default:
                if (mFragmentArticle == null) {
                    mFragmentArticle = FragmentArticle.newInstance(this,mFragmentManager);
                }
                transaction.replace(R.id.ll_content, mFragmentArticle);
                break;
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
