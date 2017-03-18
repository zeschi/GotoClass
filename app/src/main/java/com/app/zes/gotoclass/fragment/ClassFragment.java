package com.app.zes.gotoclass.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.ClassAdapter;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.app.zes.gotoclass.R.layout.fragment_class;

/**
 * Created by zes on 17-3-5 22:01
 */
public class ClassFragment extends BaseFragment {

    @Bind(R.id.class_recyclerview)
    protected RecyclerView classRecyclerView;

    private ClassAdapter classAdapter;
    private List<String> mDatas;

    @Override
    protected int getContentViewId() {

        return fragment_class;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        initData();
        classRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        classRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

        classAdapter = new ClassAdapter(getActivity(), mDatas, R.layout.item_class);
        classRecyclerView.setAdapter(classAdapter);
    }

    protected void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

}
/**
 * 　　　　　　　　┏┓　　　┏┓
 * 　　　　　　　┏┛┻━━━┛┻┓
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　　┃　＞　　　＜　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃...　⌒　...　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃   神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┗━━━┓
 * 　　　　　　　　　┃　　　　　　　┣┓
 * 　　　　　　　　　┃　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛
 */
