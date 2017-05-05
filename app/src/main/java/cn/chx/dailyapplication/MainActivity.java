package cn.chx.dailyapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import cn.chx.android.library.activity.BaseActivity;


public class MainActivity extends BaseActivity {

    private TextView tv_hello;

    @Override
    protected void initContentView(Bundle bundle) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onInitView() {
        Toast.makeText(this, ":sdadasd", Toast.LENGTH_SHORT).show();
        tv_hello = (TextView) findViewById(R.id.tv_hello);
    }

    @Override
    protected void onInitLogic() {
        tv_hello.setText("Hi~");
        tv_hello.setTextColor(getResources().getColor(R.color.black));
        mToolbar.setTitle("fff");
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }
    
}
