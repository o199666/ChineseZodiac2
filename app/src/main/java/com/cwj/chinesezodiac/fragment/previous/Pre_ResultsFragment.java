package com.cwj.chinesezodiac.fragment.previous;

import android.os.Bundle;
import android.view.View;

import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.base.BaseFragment;
import com.cwj.chinesezodiac.fragment.PreviousFragment;

/**
 * Created by CWJ on 2019/4/2.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:往期开奖结果
 */
public class Pre_ResultsFragment extends BaseFragment{
    @Override
    protected void initView(View view) {
    }
    @Override
    protected int setView() {
        return R.layout.fragment_pre_results;
    }
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    public static Pre_ResultsFragment newInstance(String info) {
        Pre_ResultsFragment oneFragment = new Pre_ResultsFragment();
        Bundle args = new Bundle();
        args.putString("info", "pre_results");
        oneFragment.setArguments(args);
        return oneFragment;
    }
    @Override
    protected void httpDate() {

    }
}
