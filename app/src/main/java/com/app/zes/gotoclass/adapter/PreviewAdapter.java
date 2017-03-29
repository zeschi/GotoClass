package com.app.zes.gotoclass.adapter;

import android.content.Context;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.model.CourseOutline;
import com.zes.bundle.adapter.BaseRecycleAdapter;
import com.zes.bundle.bean.RecycleViewHolder;

import java.util.List;

/**
 * Created by zes on 17-3-18 10:41
 */
public class PreviewAdapter extends BaseRecycleAdapter<CourseOutline> {
    public PreviewAdapter(Context context, List<CourseOutline> datas, int layoutId) {
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
    protected void convertView(RecycleViewHolder holder, CourseOutline data, int position) {
        holder.setText(R.id.tv_class_preview_lesson_name, data.getLessonName());
        List<CourseOutline.OutlineEntity> outlinesEntities = data.getOutline();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < outlinesEntities.size(); i++) {
            stringBuffer.append(outlinesEntities.get(i).getSequence() + ": " + outlinesEntities.get(i).getContent() + "\n");
        }
        holder.setText(R.id.tv_class_preview_outline, stringBuffer.toString());
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
