package feicui.edu.testfragment.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import feicui.edu.testfragment.R;

/**
 * Created by Administrator on 2016/9/28.
 */
public class OneFragment extends Fragment {
    /**
     * 给Fragmentent加载  界面
     * @param inflater   布局填充器  主要就是加载xml  fragment布局
     * @param container  容器
     * @param savedInstanceState  数据状态
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.one_fragment,container,false);
        return view;
    }
}
