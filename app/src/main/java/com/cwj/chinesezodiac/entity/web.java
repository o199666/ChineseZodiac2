package com.cwj.chinesezodiac.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by CWJ on 2019/3/28.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class web extends BmobObject {
    private String webName;
    private String webUrl;

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
