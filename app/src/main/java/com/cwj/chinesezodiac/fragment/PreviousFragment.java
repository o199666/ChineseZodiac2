package com.cwj.chinesezodiac.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;

import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.adapter.ViewPagerAdapter;
import com.cwj.chinesezodiac.base.BaseFragment;
import com.cwj.chinesezodiac.fragment.previous.Pre_AnalyzeFragment;
import com.cwj.chinesezodiac.fragment.previous.Pre_ResultsFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

/**
 * Created by CWJ on 2019/3/27.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC: 往期
 */
public class PreviousFragment extends BaseFragment {
    private ViewPager viewPager;
    private BottomNavigationView pre_top_navigation;
    private MenuItem pre_menuItem;
    private MagicIndicator magicIndicator;
    private CommonNavigator commonNavigator;

    @Override
    protected void initView(View view) {
        pre_top_navigation = view.findViewById(R.id.pre_top_navigation);
        viewPager = view.findViewById(R.id.pre_viewpager);
        pre_top_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        /**设置MenuItem的字体颜色**/
        Resources resource = (Resources) mActivity.getBaseContext().getResources();
        ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.navigation_menu_item_color);
        pre_top_navigation.setItemTextColor(csl);
        /**设置MenuItem默认选中项**/
        pre_top_navigation.getMenu().getItem(0).setChecked(true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                if (pre_menuItem != null) {
                    pre_menuItem.setChecked(false);
                } else {
                    pre_top_navigation.getMenu().getItem(0).setChecked(false);
                }
                pre_menuItem = pre_top_navigation.getMenu().getItem(i);
                pre_menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(mActivity.getSupportFragmentManager());
        adapter.addFragment(Pre_ResultsFragment.newInstance("往期开奖结果"));
        adapter.addFragment(Pre_AnalyzeFragment.newInstance("往期分析结果"));
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int setView() {
        return R.layout.fragment_previous;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void httpDate() {
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.item_one:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.item_two:
                    viewPager.setCurrentItem(1);
                    break;
            }
            return false;
        }
    };

    public static PreviousFragment newInstance(String info) {
        PreviousFragment oneFragment = new PreviousFragment();
        Bundle args = new Bundle();
        args.putString("info", "prev");
        oneFragment.setArguments(args);
        return oneFragment;
    }
}
