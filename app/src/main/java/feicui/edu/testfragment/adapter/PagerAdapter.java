package feicui.edu.testfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/28.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> mFment;
    public PagerAdapter(FragmentManager fm, ArrayList<Fragment> mList) {
        super(fm);
        mFment=mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFment.get(position);
    }

    @Override
    public int getCount() {
        return mFment==null?0:mFment.size();
    }
}
