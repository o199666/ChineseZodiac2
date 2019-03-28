package com.cwj.chinesezodiac.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

/**
 * Created by CWJ on 2019/3/27.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC: 所有页面的父类
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    public void onAttach(Context Context) {
        super.onAttach(Context);
        mActivity = (BaseActivity) Context;
        Logger.d(TAG + "：onAttach：附加");
    }

    /**
     * 初始化控件
     * @param view
     */
    protected abstract void initView(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            Logger.d(TAG + "不涉及UI：setUserVisibleHint：可见");
        }
    }

    /**
     * 设置布局位置。
     *
     * @return
     */
    protected abstract int setView();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(TAG + "：onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.d(TAG + "：onCreateView：创建视图");
        return inflater.inflate(setView(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.d(TAG + "：onViewCreated：视图创建完毕");
        initView(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
        Logger.d(TAG + "：onActivityCreated:页面完成");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(TAG + "：onStart: 启动");
        if (getUserVisibleHint()) {//涉及到UI
            Logger.d(TAG + "：onStart: 涉及到UI的数据填充。");
            httpDate();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(TAG + "：onResume：绘制");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(TAG + "：onPause: 暂停");

    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(TAG + "：onStop: 停止");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d(TAG + "：onDestroyView：销毁视图");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG + "：onDestroy: 销毁整个页面");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(TAG + "：onDetach:分离");
    }

//    protected abstract int setView();

//    protected abstract void init(View view);

    /**
     * 静态数据
     *
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 需要更新UI的网络数据
     */
    protected abstract void httpDate();
}
