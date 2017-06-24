package com.meituan.cloud.classmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meituan.cloud.classmonitor.R;
import com.meituan.cloud.classmonitor.model.Course;

import java.util.ArrayList;

/**
 * Created by xuhongxu on 2017/6/24.
 */

public class CourseListRecyclerAdapter
        extends RecyclerView.Adapter<CourseListRecyclerAdapter.ItemViewHolder> {

    public static final int LIST_ITEM_RESOURCE_ID = R.layout.item_course_list;

    Context mContext = null;
    ArrayList<Course> mValues;

    public CourseListRecyclerAdapter(Context context, ArrayList<Course> courseList) {
        mContext = context;
        mValues = courseList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(LIST_ITEM_RESOURCE_ID,
                        parent,
                        false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Course item = mValues.get(position);

        holder.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public final class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public ItemViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.course_name);
        }
    }
}
