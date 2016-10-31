package feicui.edu.testfragment.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import feicui.edu.testfragment.R;

public class MainActivity extends FragmentActivity implements AdapterView.OnItemClickListener {
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        String[] arr={"添加","替换","删除"};
        mListView= (ListView) findViewById(R.id.lv_main);
        mListView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arr));
        mListView.setOnItemClickListener(this); //子条目点击事件

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.ll_main,one); //添加 拼接
        transaction.add(R.id.ll_main,two);
        transaction.hide(two);//隐藏
        transaction.show(one); //显示
        transaction.commit();//提交
    }
     TwoFragment two=new TwoFragment();
     OneFragment one=new OneFragment();
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0: //添加
                FragmentManager manager=getSupportFragmentManager(); //获取支持碎片管理
                FragmentTransaction transaction=manager.beginTransaction(); //开始碎片事务
                transaction.hide(two);//隐藏
                transaction.show(one);//显示
                transaction.commit();  //提交
                break;
            case 1: //替换
                FragmentManager manager1=getSupportFragmentManager();
                FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.hide(one); //隐藏
                transaction1.show(two);  //显示
                transaction1.commit();  //提交
                break;
            case 2: //删除
                FragmentManager manager2=getSupportFragmentManager();
                FragmentTransaction transaction2=manager2.beginTransaction();
                transaction2.remove(two); //删除
                transaction2.commit();  //提交
                break;
        }
    }
    /**
     *  Fragment 碎片  3.0以后推出的
     *    只要用来加载到Activity 中进行显示
     *    功能： 用来 交互 展示界面
     *  使用：
     *  1.xml
     *     a：布局中  新建一个fragment标签
     *     b：新建一个Fragment  继承自Fragment(v4，app)
     *   注意：app--》Fragment---》Activity---》FramentManager(app)--get
     *    v4---》Fragment-----》FragmentActivity————》FragmentManager（v4）--》getSupport
     *       需要给fragment 添加id
     *  2.代码
     *      a：拿到FragmentManager
     *        getSupportFragmentManager  getFragmentManager
     *      b：nadaoFragmentTransaction
     *          beginTransaction
     *      c：事务需要提交 《 commit（）》
     *          1.replace  直接切换
     *          2.先添加你所需要的所有的Fragment  通过  hide show 控制隐藏和显示
     *
     *
     * 生命周期：
     *    onAttzch---------》当Activity和 碎片相关联的时候执行  add
     *    onCreat---------->
     *
     */


}
