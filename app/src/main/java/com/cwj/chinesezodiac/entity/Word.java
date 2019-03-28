package com.cwj.chinesezodiac.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by CWJ on 2019/3/19.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class Word extends BmobObject {
    private String zodiac;

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
}
