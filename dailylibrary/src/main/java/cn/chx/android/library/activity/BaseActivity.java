package cn.chx.android.library.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.chx.dailylibrary.R;

/**
 * Created by HanseyChan on 2017/4/28 0028.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected BaseActivity context;
    protected Toolbar mToolbar;
    protected TextView mTvCenterTitle;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }

        context = this;
        initContentView(savedInstanceState);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar != null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            initTitle();
        }
        onInitView();
        onInitLogic();
    }

    protected abstract void initContentView(Bundle bundle);
    protected abstract void onInitView();
    protected abstract void onInitLogic();

    /**
     * Bundle  传递数据
     *
     * @param extras
     */
    protected abstract void getBundleExtras(Bundle extras);

    protected void initTitle() {
        //  设置Toolbar title文字颜色
        mToolbar.setTitleTextColor(Color.WHITE);
        //设置NavigationIcon
        mToolbar.setNavigationIcon(R.mipmap.navigation_back_white);
        // 设置navigation button 点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTvCenterTitle = (TextView) findViewById(R.id.tv_centerTitle);
    }

    public void showToast(String toastValue){
        Toast.makeText(this, "" + toastValue, Toast.LENGTH_SHORT).show();
    }

    public void showToastInt(int stringRes){
        Toast.makeText(this, this.getResources().getString(stringRes), Toast.LENGTH_SHORT).show();
    }

}
