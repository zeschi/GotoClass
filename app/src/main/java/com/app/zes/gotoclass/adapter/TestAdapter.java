package com.app.zes.gotoclass.adapter;

import android.content.Context;

import com.app.zes.gotoclass.R;
import com.zes.bundle.adapter.BaseRecycleAdapter;
import com.zes.bundle.bean.RecycleViewHolder;

import java.util.List;

/**
 * Created by zes on 17-4-8 16:38
 */
public class TestAdapter extends BaseRecycleAdapter<String> {
    public TestAdapter(Context context, List<String> datas, int layoutId) {
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
    protected void convertView(RecycleViewHolder holder, String data, int position) {
        holder.setText(R.id.tv_score_class, data);
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
