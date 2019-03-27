package com.cwj.chinesezodiac.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by CWJ on 2019/3/27.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:所有页面的父类
 */
public abstract class BaseActivity extends AppCompatActivity {
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLyoutId());
        initLogger();
        initView();
        initDate();
    }

    public void initLogger() {
        Logger.init(TAG)    //LOG TAG默认是PRETTYLOGGER
                .methodCount(3)                 // 决定打印多少行（每一行代表一个方法）默认：2
                .hideThreadInfo()               // 隐藏线程信息 默认：显示
                .logLevel(LogLevel.NONE)        // 是否显示Log 默认：LogLevel.FULL（全部显示）
                .methodOffset(2);                // 默认：0
    }

    /**
     * 所有初始化的空间放这个里面。
     *
     * @param
     */

    public abstract void initView();

    public abstract int setLyoutId();

    /**
     * 数据初始化
     */
    public abstract void initDate();

    @Override
    public void onRestart() {
        super.onRestart();
        Logger.d(TAG, "onRestart: 重启");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(TAG, "onRestart: 启动");

    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(TAG, "onRestart: 绘制");

    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(TAG, "onRestart: 暂停");

    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(TAG, "onRestart: 停止");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG, "onRestart: 销毁");

    }

    /**
     * 显示长toast
     *
     * @param msg
     */
    public void tLong(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    /**
     * 显示短toast
     *
     * @param msg
     */
    public void tShort(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }


    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 跳转页面
     *
     * @param clz         所跳转的Activity类
     * @param requestCode 请求码
     */
    public void startActivityForResult(Class<?> clz, int requestCode) {
        startActivityForResult(new Intent(this, clz), requestCode);
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转页面
     *
     * @param clz         所跳转的Activity类
     * @param bundle      跳转所携带的信息
     * @param requestCode 请求码
     */
    public void startActivityForResult(Class<?> clz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivityForResult(intent, requestCode);
    }
}
