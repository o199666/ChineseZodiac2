package com.cwj.chinesezodiac.fragment;

import android.os.Bundle;
import android.view.View;

import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.base.BaseFragment;

/**
 * Created by CWJ on 2019/3/27.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC: 管理/代理页面。需要输入授权码即可进入
 */
public class AdminFragment extends BaseFragment {
    @Override
    protected void initView(View view) {
    }

    @Override
    protected int setView() {
        return R.layout.fragment_admin;
    }
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void httpDate() {

    }

    public static AdminFragment newInstance(String info) {
        AdminFragment oneFragment = new AdminFragment();
        Bundle args = new Bundle();
        args.putString("info", "admin");
        oneFragment.setArguments(args);
        return oneFragment;
    }
}
