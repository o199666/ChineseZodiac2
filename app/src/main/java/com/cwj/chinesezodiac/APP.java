package com.cwj.chinesezodiac;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by CWJ on 2019/3/19.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "68a41f97106914f7d904c0671a0415bf");
    }
}
