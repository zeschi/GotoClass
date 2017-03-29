package com.app.zes.gotoclass.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.InteractAdapter;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by zes on 17-3-18 10:09
 */
public class InteractFragment extends BaseFragment {
    @Bind(R.id.interact_rv)
    RecyclerView interactRv;

    private InteractAdapter adapter;
    private List<String> mDatas;


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_interact;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        initData();
        adapter = new InteractAdapter(getActivity(), mDatas, R.layout.item_interact);
        interactRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        interactRv.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        interactRv.setAdapter(adapter);
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
