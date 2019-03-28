package com.cwj.chinesezodiac.activity;


import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.cwj.chinesezodiac.R;
import com.cwj.chinesezodiac.adapter.ViewPagerAdapter;
import com.cwj.chinesezodiac.base.BaseActivity;
import com.cwj.chinesezodiac.fragment.AdminFragment;
import com.cwj.chinesezodiac.fragment.DataSetFragment;
import com.cwj.chinesezodiac.fragment.PreviousFragment;
import com.cwj.chinesezodiac.fragment.UnderwayFragment;

public class MainActivity extends BaseActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private MenuItem menuItem;

    @Override
    public void initView() {
        viewPager = findViewById(R.id.viewpager);
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //避免图片被系统渲染
        navigationView.setItemIconTintList(null);
        /**设置MenuItem的字体颜色**/
        Resources resource = (Resources) getBaseContext().getResources();
        ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.navigation_menu_item_color);
        navigationView.setItemTextColor(csl);
        /**设置MenuItem默认选中项**/
        navigationView.getMenu().getItem(0).setChecked(true);
        //禁止ViewPager滑动
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }
            @Override
            public void onPageSelected(int i) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigationView.getMenu().getItem(i);
                menuItem.setChecked(true);
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(viewPager);
    }

    @Override
    public int setLyoutId() {
        return R.layout.activity_main;
    }
    @Override
    public void initDate() {

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
                case R.id.item_data:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.item_admin:
                    viewPager.setCurrentItem(3);
                    break;
            }
            return false;
        }
    };

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(UnderwayFragment.newInstance("当期"));
        adapter.addFragment(PreviousFragment.newInstance("往期"));
        adapter.addFragment(DataSetFragment.newInstance("资料"));
        adapter.addFragment(AdminFragment.newInstance("会员"));
        viewPager.setAdapter(adapter);
    }
}
