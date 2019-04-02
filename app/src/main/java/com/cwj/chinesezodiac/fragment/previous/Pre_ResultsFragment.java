package com.cwj.chinesezodiac.fragment.previous;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.adapter.AnalyzeAdapter;
import com.cwj.chinesezodiac.base.BaseFragment;
import com.cwj.chinesezodiac.entity.Analyze;
import com.cwj.chinesezodiac.entity.Word;
import com.cwj.chinesezodiac.fragment.PreviousFragment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by CWJ on 2019/4/2.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:往期开奖结果
 */
public class Pre_ResultsFragment extends BaseFragment {
    private AnalyzeAdapter adapter;
    private List<Analyze> analyzeList;
    private RecyclerView recyclerlist;

    @Override
    protected void initView(View view) {
        recyclerlist = view.findViewById(R.id.recyclerlist);
        recyclerlist.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int setView() {
        return R.layout.fragment_pre_results;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        analyzeList = new ArrayList<>();
    }

    /**
     * 查询数据
     */
    public void queryAnalyzes() {
        BmobQuery<Analyze> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<Analyze>() {
            @Override
            public void done(List<Analyze> bmobs, BmobException e) {
                if (e == null) {
                    Log.e("BMOB:===", bmobs.size() + "");
                    analyzeList = bmobs;
                    adapter = new AnalyzeAdapter(analyzeList, getActivity());
                    recyclerlist.setAdapter(adapter);

                } else {
                    Log.e("BMOB", e.toString());
                }
            }
        });
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
        queryAnalyzes();
    }
}
