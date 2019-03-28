package com.cwj.chinesezodiac.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.entity.web;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by CWJ on 2019/3/28.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:web适配器
 */
public class WebAdapter extends BaseQuickAdapter<web, BaseViewHolder> {
    private Activity activity;

    public WebAdapter(@Nullable List<web> data, Activity activity) {
        super(R.layout.item_zoiiacziliao, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, web item) {
        TextView tv = helper.getView(R.id.tv);
        tv.setText(item.getWebName() + "");
    }
}
