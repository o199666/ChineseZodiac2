package com.cwj.chinesezodiac;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import static com.cwj.chinesezodiac.Config.SFENXIS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] xiao = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    List<String> list = new ArrayList<>();//每句话
    private Button addBtn, analyzeBtn;
    private EditText editText;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.add_btn);
        analyzeBtn = findViewById(R.id.analyze_btn);
        editText = findViewById(R.id.et_date);
        recyclerView = findViewById(R.id.recyclerView);
        addBtn.setOnClickListener(this);
        analyzeBtn.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        query();
    }

    /**
     * 添加数据到集合中
     *
     * @param zodic
     */
    public void add(String zodic) {
        list.add(zodic);
        //添加一次改变一次数组
        recyclerView.setAdapter(new ZodiacAdapter(list, this));
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
        SFENXIS = fenxis;

        Intent intent = new Intent(this, ResultActivity.class);

        intent.putStringArrayListExtra("infoList", fenxis);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fenxis.clear();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_btn:
                //添加数据
                if (editText.getText().toString().length() <= 1) {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    add(editText.getText().toString());
                    editText.setText("");
                }
                break;
            case R.id.analyze_btn:
//                analyzeResults(compare());
//                fenxi();
                compare();
                fenxi();
                break;
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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
}
