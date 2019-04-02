package com.cwj.chinesezodiac.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.activity.ResultActivity;
import com.cwj.chinesezodiac.entity.Word;
import com.cwj.chinesezodiac.adapter.ZodiacAdapter;
import com.cwj.chinesezodiac.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import static com.cwj.chinesezodiac.config.Config.SFENXIS;

/**
 * Created by CWJ on 2019/3/27.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:现在
 */
public class UnderwayFragment extends BaseFragment implements View.OnClickListener {

    private String[] xiao = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    List<String> list = new ArrayList<>();//每句话
    private Button   analyzeBtn;
    private RecyclerView recyclerView;

    @Override
    protected void initView(View view) {
        analyzeBtn = view.findViewById(R.id.analyze_btn);
        recyclerView = view.findViewById(R.id.recyclerView);
        analyzeBtn.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    @Override
    protected int setView() {
        return R.layout.fragment_underway;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
    @Override
    protected void httpDate() {
        list.clear();
        query();
//        testQuerya();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.analyze_btn:
                compare();
                fenxi();
                break;
        }
    }
    void testQuerya(){
        for (int i = 0; i < 19; i++) {
            add("萨克等哈开啥都好");
        }
    }
    private void query() {
        BmobQuery<Word> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<Word>() {
            @Override
            public void done(List<Word> bmobs, BmobException e) {
                if (e == null) {
                    Log.e("BMOB:===", bmobs.size() + "");
                    for (int i = 0; i < bmobs.size(); i++) {
                        Log.e("BMOB:===", i + "" + bmobs.get(i).getZodiac());
                        add(bmobs.get(i).getZodiac());
                    }

                } else {
                    Log.e("BMOB", e.toString());
                }
            }
        });
    }

    /**
     * 添加数据到集合中
     *
     * @param zodic
     */
    public void add(String zodic) {
        list.add(zodic);
        //添加一次改变一次数组
        recyclerView.setAdapter(new ZodiacAdapter(list, getContext()));
    }

    /**
     * 比较每句话,得出包含的生肖
     *
     * @return
     */
    List<String> results = new ArrayList<>();

    /**
     * 每句话的每个字
     *
     * @return
     */
    public List<String> compare() {
        //最外层的12遍
        //每句话的每一个字 都要跟 最外层的比较
        for (int j = 0; j < list.size(); j++) {
            //每句话的长度
            for (int k = 0; k < list.get(j).length(); k++) {
                Log.e("每句话，每个字-！", list.get(j).charAt(k) + "");
                results.add(list.get(j).charAt(k) + "");
            }
        }
        return results;
    }

    /**
     * 每句话每个字分别跟12生肖对比
     */
    ArrayList<String> fenxis = new ArrayList<>();

    public void fenxi() {
        Log.e("-所有的结果-", "" + results.size());
        if (results != null || results.size() > 0) {
            for (int i = 0; i < xiao.length; i++) {
                for (int j = 0; j < results.size(); j++) {
                    if (xiao[i].equals(results.get(j))) {
                        fenxis.add(results.get(j));
                    }
                }
            }
        }
        Log.e("-符合的结果-", "" + fenxis.size());

        Intent intent = new Intent(getContext(), ResultActivity.class);
        intent.putStringArrayListExtra("infoList", fenxis);
        startActivityForResult(intent, 1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fenxis.clear();
    }

    public static UnderwayFragment newInstance(String info) {
        UnderwayFragment oneFragment = new UnderwayFragment();
        Bundle args = new Bundle();
        args.putString("info", "under");
        oneFragment.setArguments(args);
        return oneFragment;
    }
}
