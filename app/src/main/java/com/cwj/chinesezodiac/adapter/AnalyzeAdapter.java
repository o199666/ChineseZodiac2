package com.cwj.chinesezodiac.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.entity.Analyze;

import java.util.List;

/**
 * Created by CWJ on 2019/3/19.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:wang'qi往期结果
 */
public class AnalyzeAdapter extends RecyclerView.Adapter<AnalyzeAdapter.MyViewHolder> {
    List<Analyze> list;
    Context context;

    public AnalyzeAdapter(List<Analyze> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_analyze, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder vh, int i) {
        vh.periods.setText(list.get(i).getPeriods());
        vh.shu_tv.setText(list.get(i).getShu());
        vh.niu_tv.setText(list.get(i).getNiu());
        vh.hu_tv.setText(list.get(i).getHu());
        vh.tu_tv.setText(list.get(i).getTu());
        vh.longg_tv.setText(list.get(i).getLongg());
        vh.she_tv.setText(list.get(i).getShe());
        vh.ma_tv.setText(list.get(i).getMa());
        vh.yang_tv.setText(list.get(i).getYang());
        vh.hou_tv.setText(list.get(i).getGou());
        vh.ji_tv.setText(list.get(i).getJi());
        vh.gou_tv.setText(list.get(i).getGou());
        vh.zhu_tv.setText(list.get(i).getZhu());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView periods, shu_tv, niu_tv, hu_tv, tu_tv, longg_tv, she_tv, ma_tv, yang_tv, hou_tv, ji_tv, gou_tv, zhu_tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            shu_tv = itemView.findViewById(R.id.shu_tv);
            periods = itemView.findViewById(R.id.periods);
            niu_tv = itemView.findViewById(R.id.niu_tv);
            hu_tv = itemView.findViewById(R.id.hu_tv);
            tu_tv = itemView.findViewById(R.id.tu_tv);
            longg_tv = itemView.findViewById(R.id.longg_tv);
            she_tv = itemView.findViewById(R.id.she_tv);
            ma_tv = itemView.findViewById(R.id.ma_tv);
            yang_tv = itemView.findViewById(R.id.yang_tv);
            hou_tv = itemView.findViewById(R.id.hou_tv);
            ji_tv = itemView.findViewById(R.id.ji_tv);
            gou_tv = itemView.findViewById(R.id.gou_tv);
            zhu_tv = itemView.findViewById(R.id.zhu_tv);
        }
    }
}
