package com.app.zes.gotoclass.adapter;

import android.content.Context;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.model.CourseFeedback;
import com.zes.bundle.adapter.BaseRecycleAdapter;
import com.zes.bundle.bean.RecycleViewHolder;

import java.util.List;

/**
 * Created by zes on 17-3-18 11:07
 */
public class FeedbackAdapter extends BaseRecycleAdapter<CourseFeedback> {
    public FeedbackAdapter(Context context, List<CourseFeedback> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    /**
     * 所有子类的逻辑代码的实现
     *
     * @param holder
     * @param data
     * @param position
     */
    @Override
    protected void convertView(RecycleViewHolder holder, CourseFeedback data, int position) {
        holder.setText(R.id.tv_item_feedback_user_name, data.getUsername());
        holder.setText(R.id.tv_item_feedback_time, data.getTime());
        holder.setText(R.id.tv_item_feedback_content, data.getContent());
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
