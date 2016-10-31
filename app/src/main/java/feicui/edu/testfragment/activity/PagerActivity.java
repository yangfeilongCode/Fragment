package feicui.edu.testfragment.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import feicui.edu.testfragment.R;
import feicui.edu.testfragment.adapter.PagerAdapter;

/**
 * Created by Administrator on 2016/9/28.
 */
public class PagerActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
   ViewPager mViewPager;  //左右滑动控件
    ArrayList<Fragment> mList=new ArrayList<>(); //数据源
    RadioGroup mRadioGroup; //单选框组件
    RadioButton mRadioButton; //单选按钮

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_activity); //加载布局
}

    @Override
    public void onContentChanged() {
        super.onContentChanged();
       //通过Id 找到相应控件的对象
        mViewPager= (ViewPager) findViewById(R.id.vp_pager); //左右滑动
        mRadioGroup= (RadioGroup) findViewById(R.id.rg_pager); //单选组件
        mRadioButton= (RadioButton) findViewById(R.id.pager_one); //第一个单选按钮
        mRadioButton.setChecked(true); //设置第一个单选按钮被选中
        //数据源
        mList.add(new OneFragment()); //添加数据
        mList.add(new TwoFragment());
        mList.add(new ThreeFragment());
        //适配器
        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager(),mList);
        mViewPager.setAdapter(pagerAdapter); //左右滑动控件绑定适配器
        mViewPager.addOnPageChangeListener(this); // 添加页面改变监听事件
        mRadioGroup.setOnCheckedChangeListener(this); //设置选中监听事件
    }

    /**
     * 页面卷曲
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     *  页面选择
     * @param position 下标
     */
    @Override
    public void onPageSelected(int position) {
        //通过单选按钮组件获取单选子件下标
        RadioButton button= (RadioButton) mRadioGroup.getChildAt(position);
        button.setChecked(true); //设置被点击
    }

    @Override
    public void onPageScrollStateChanged(int state) {  //卷曲情况

    }

    /**
     * 选中监听
     * @param group
     * @param checkedId   当前状态
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        for (int i=0;i<group.getChildCount();i++){
            RadioButton button= (RadioButton) group.getChildAt(i);
            if(button.getId()==checkedId){ //通过ID判断是否与当前状态相同
                mViewPager.setCurrentItem(i);
            }
        }
    }
}
