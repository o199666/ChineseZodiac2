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
 * DEC: 往期
 */
public class PreviousFragment extends BaseFragment {
    @Override
    protected void initView(View view) {
    }

    @Override
    protected int setView() {
        return R.layout.fragment_previous;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void httpDate() {
    }

    public static PreviousFragment newInstance(String info) {
        PreviousFragment oneFragment = new PreviousFragment();
        Bundle args = new Bundle();
        args.putString("info", "prev");
        oneFragment.setArguments(args);
        return oneFragment;
    }
}
