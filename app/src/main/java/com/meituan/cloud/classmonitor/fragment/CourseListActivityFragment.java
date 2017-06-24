package com.meituan.cloud.classmonitor.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meituan.cloud.classmonitor.R;
import com.meituan.cloud.classmonitor.adapter.CourseListRecyclerAdapter;
import com.meituan.cloud.classmonitor.model.Course;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CourseListActivityFragment extends Fragment {

    ImageView mUserAvatarView = null;
    TextView mUserNameView = null;
    RecyclerView mCourseListRecyclerView = null;
    ArrayList<Course> mCourseModels = new ArrayList<>();
    CourseListRecyclerAdapter mCourseListAdapter = null;

    public CourseListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course_list, container, false);

        mUserAvatarView = (ImageView) v.findViewById(R.id.user_avatar);
        mUserNameView = (TextView) v.findViewById(R.id.user_name);

        mCourseListRecyclerView = (RecyclerView) v.findViewById(R.id.course_list_recycler_view);
        mCourseListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCourseListRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        mCourseListRecyclerView.setLayoutManager(layoutManager);
        mCourseListAdapter = new CourseListRecyclerAdapter(getContext(), mCourseModels);
        mCourseListRecyclerView.setAdapter(mCourseListAdapter);

        mCourseListRecyclerView.addOnItemTouchListener();

        return v;
    }
}
