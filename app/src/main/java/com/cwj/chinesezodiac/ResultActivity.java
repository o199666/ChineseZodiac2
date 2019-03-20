package com.cwj.chinesezodiac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import static com.cwj.chinesezodiac.Config.SFENXIS;

/**
 * Created by CWJ on 2019/3/19.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class ResultActivity extends AppCompatActivity {
    private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    ArrayList<String> infoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1 = findViewById(R.id.zod1);
        t2 = findViewById(R.id.zod2);
        t3 = findViewById(R.id.zod3);
        t4 = findViewById(R.id.zod4);
        t5 = findViewById(R.id.zod5);
        t6 = findViewById(R.id.zod6);
        t7 = findViewById(R.id.zod7);
        t8 = findViewById(R.id.zod8);
        t9 = findViewById(R.id.zod9);
        t10 = findViewById(R.id.zod10);
        t11 = findViewById(R.id.zod11);
        t12 = findViewById(R.id.zod12);
        infoList = new ArrayList<String>();
        infoList = getIntent().getStringArrayListExtra("infoList");
        re();
    }

    int a, b, c, d, e, f, g, h, l, j, k, o;

    public void re() {
        for (int i = 0; i < infoList.size(); i++) {
            switch (infoList.get(i)) {
                case "鼠":
                    a++;
                    t1.setText("鼠：" + a);
                    break;
                case "牛":
                    b++;
                    t2.setText("牛：" + b);
                    break;
                case "虎":
                    c++;
                    t3.setText("虎：" + c);
                    break;
                case "兔":
                    d++;
                    t4.setText("兔：" + d);
                    break;
                case "龙":
                    e++;
                    t5.setText("龙：" + e);
                    break;
                case "蛇":
                    f++;
                    t6.setText("蛇：" + f);
                    break;
                case "马":
                    o++;
                    t7.setText("马：" + o);
                    break;
                case "羊":
                    g++;
                    t8.setText("羊：" + g);
                    break;
                case "猴":
                    h++;
                    t9.setText("猴：" + h);
                    break;
                case "鸡":
                    l++;
                    t10.setText("鸡：" + l);
                    break;
                case "狗":
                    j++;
                    t11.setText("狗：" + j);
                    break;
                case "猪":
                    k++;
                    t12.setText("猪：" + k);
                    break;
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SFENXIS.clear();
        SFENXIS = null;
    }
}
