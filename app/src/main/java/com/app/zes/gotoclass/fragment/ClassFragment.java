package com.app.zes.gotoclass.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.activity.ClassDetailActivity;
import com.app.zes.gotoclass.adapter.ClassAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.Course;
import com.app.zes.gotoclass.utils.RxBus;
import com.app.zes.gotoclass.view.RefreshRecyclerView;
import com.zes.bundle.adapter.BaseRecycleAdapter;
import com.zes.bundle.bean.RecycleViewHolder;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.utils.MKToast;
import com.zes.bundle.view.DividerItemDecoration;

import java.util.List;

import butterknife.Bind;

import static com.app.zes.gotoclass.R.layout.fragment_class;

/**
 * Created by zes on 17-3-5 22:01
 */
public class ClassFragment extends BaseFragment implements BaseRecycleAdapter.OnItemClickListener {

    @Bind(R.id.class_recyclerview)
    protected RefreshRecyclerView classRecyclerView;

    @Bind(R.id.srl)
    protected SwipeRefreshLayout swipeRefreshLayout;
    private ClassAdapter classAdapter;


    private List<Course> courseList;
    private int currentPage;

    @Override
    protected int getContentViewId() {

        return fragment_class;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_green_light);

        classRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        classRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        classRecyclerView.setLoadMoreEnable(true);
        classRecyclerView.setFooterResource(R.layout.item_footer);
        initListener();

        currentPage = 1;
        ApiFactory.findUserCourses(currentPage, 10).subscribe(courses -> {
            if (classRecyclerView != null && classAdapter == null) {
                classAdapter = new ClassAdapter(getActivity(), courses, R.layout.item_class);
                classRecyclerView.setAdapter(classAdapter);
                classAdapter.setOnItemClickLitener(this);
            } else {
                classAdapter.setData(courses);
                classRecyclerView.setAdapter(classAdapter);
            }
            currentPage++;
        });

        RxBus.getInstance().toObserverable(Integer.class).subscribe(integer -> {
            ApiFactory.findUserCourses(1, 10).subscribe(courses -> {
                if (courses != null) {
                    classAdapter.clear();
                    currentPage = 2;
                    classAdapter.setData(courses);
                    classRecyclerView.notifyData();
                }
            });
        });
    }


    private void initListener() {
        classRecyclerView.setOnLoadMoreListener(() -> ApiFactory.findUserCourses(currentPage, 10).subscribe(courses -> {
            currentPage++;
            if (courses != null) {
                if (courses.size() == 0) {
                    MKToast.showToast(getActivity(), "暂无更多数据");
                } else {
                    classAdapter.addAll(courses);
                }
                classRecyclerView.notifyData();
                courseList = courses;
            }
        }));

        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            ApiFactory.findUserCourses(1, 10).subscribe(courses -> {
                if (courses != null) {
                    classAdapter.clear();
                    currentPage = 2;
                    classAdapter.setData(courses);
                    classRecyclerView.notifyData();
                }
            });
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
