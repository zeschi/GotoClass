package com.app.zes.gotoclass.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.activity.ClassDetailActivity;
import com.app.zes.gotoclass.adapter.ClassAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.zes.bundle.adapter.BaseRecycleAdapter;
import com.zes.bundle.bean.RecycleViewHolder;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.view.DividerItemDecoration;

import butterknife.Bind;

import static com.app.zes.gotoclass.R.layout.fragment_class;

/**
 * Created by zes on 17-3-5 22:01
 */
public class ClassFragment extends BaseFragment implements BaseRecycleAdapter.OnItemClickListener {

    @Bind(R.id.class_recyclerview)
    protected RecyclerView classRecyclerView;

    private ClassAdapter classAdapter;

    @Override
    protected int getContentViewId() {

        return fragment_class;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        classRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        classRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

        ApiFactory.findUserCourses(1, 10).subscribe(courses -> {
            if (classAdapter == null) {
                classAdapter = new ClassAdapter(getActivity(), courses, R.layout.item_class);
                classRecyclerView.setAdapter(classAdapter);
                classAdapter.setOnItemClickLitener(this);
            }
        });

    }


    @Override
    public void onItemClick(RecycleViewHolder holder, View view, int position) {
//        redirectActivity(getActivity(), ClassDetailActivity.class);
        Intent intent = new Intent(getActivity(), ClassDetailActivity.class);
        intent.putExtra("lessonId", classAdapter.getData().get(position).getLessonId());
        intent.putExtra("courseId", classAdapter.getData().get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {

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
