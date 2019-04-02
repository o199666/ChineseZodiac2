package com.cwj.chinesezodiac.fragment;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.adapter.WebAdapter;
import com.cwj.chinesezodiac.base.BaseFragment;
import com.cwj.chinesezodiac.entity.Word;
import com.cwj.chinesezodiac.entity.web;
import com.tencent.smtt.sdk.WebChromeClient;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by CWJ on 2019/3/27.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC: 数据集合
 */
public class DataSetFragment extends BaseFragment {
    private WebAdapter webAdapter;
    private List<web> webs;
    private RecyclerView recyclerView;
    private WebView tt_wv;


    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.web_list);
        tt_wv = view.findViewById(R.id.tt_wv);
        tt_wv.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void initWeb(String URL) {
        tt_wv.setVisibility(View.VISIBLE);
//        webView.loadUrl("http://www.google.com/")
        tt_wv.getSettings().setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        tt_wv.getSettings().setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        tt_wv.getSettings().setDisplayZoomControls(true); //隐藏原生的缩放控件
        tt_wv.getSettings().setBlockNetworkImage(false);//解决图片不显示
        tt_wv.getSettings().setLoadsImagesAutomatically(true); //支持自动加载图片
        tt_wv.getSettings().setDefaultTextEncodingName("utf-8");//设置编码格式
        tt_wv.loadUrl(URL);
        //该界面打开更多链接
        tt_wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });
        tt_wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
                //handler.cancel();// super中默认的处理方式，WebView变成空白页
                if (handler != null) {
                    //忽略证书的错误继续加载页面内容，不会变成空白页面
                    handler.proceed();
                }
            }
        });
    }

    @Override
    protected int setView() {
        return R.layout.fragment_dataset;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void httpDate() {
        query();
    }

    public static DataSetFragment newInstance(String info) {
        DataSetFragment oneFragment = new DataSetFragment();
        Bundle args = new Bundle();
        args.putString("info", "dataset");
        oneFragment.setArguments(args);
        return oneFragment;
    }

    //查询资料
    private void query() {
        BmobQuery<web> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<web>() {
            @Override
            public void done(List<web> bmobs, BmobException e) {
                if (e == null) {
                    Log.e("BMOB:===", bmobs.size() + "");
                    webs = bmobs;
                    webAdapter = new WebAdapter(webs, getActivity());
                    recyclerView.setAdapter(webAdapter);
                    webAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            initWeb(webs.get(position).getWebUrl());
                        }
                    });
                } else {
                    Log.e("BMOB", e.toString());
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        tt_wv.onPause();
        tt_wv.getSettings().setLightTouchEnabled(false);
    }

    @Override
    public void onDestroy() {
        if (this.tt_wv != null) {
            tt_wv.destroy();
        }
        super.onDestroy();
    }
}
