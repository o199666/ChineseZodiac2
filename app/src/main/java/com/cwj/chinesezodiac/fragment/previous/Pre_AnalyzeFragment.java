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
 * DEC:往期分析结果
 */
public class Pre_AnalyzeFragment extends BaseFragment {
    @Override
    protected void initView(View view) {

    }

    @Override
    protected int setView() {
        return R.layout.fragment_pre_analyze;
    }
    public static Pre_AnalyzeFragment newInstance(String info) {
        Pre_AnalyzeFragment oneFragment = new Pre_AnalyzeFragment();
        Bundle args = new Bundle();
        args.putString("info", "pre_analyze");
        oneFragment.setArguments(args);
        return oneFragment;
    }
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void httpDate() {

    }
}
