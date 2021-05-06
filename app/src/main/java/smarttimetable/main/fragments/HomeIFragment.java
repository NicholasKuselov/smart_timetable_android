package smarttimetable.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.IFragmentNotifier;
import smarttimetable.main.Model.LessonsListAdapter;
import smarttimetable.main.R;


public class HomeIFragment extends Fragment implements IFragmentNotifier {

    ListView lv_TodayLessons;
    LessonsListAdapter lessonsListAdapter;

    ConstraintLayout nextLessonInfo;
    TextView tv_TodayLessonsNull;
    TextView tv_nextLessonNull;
    TextView tv_nextLessonName;
    TextView tv_nextLessonTime;
    TextView tv_nextLessonTimeLeft;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        lv_TodayLessons = (ListView)root.findViewById(R.id.lv_LessonsToday);
        tv_nextLessonName = root.findViewById(R.id.tv_nextLessonName);
        tv_nextLessonTime = root.findViewById(R.id.tv_nextLessonTime);
        tv_nextLessonTimeLeft = root.findViewById(R.id.tv_nextLessonTimeLeft);
        tv_nextLessonNull = root.findViewById(R.id.tv_nextLessonNull);
        tv_TodayLessonsNull = root.findViewById(R.id.tv_todayLessonsNull);
        nextLessonInfo = root.findViewById(R.id.nextLessonInfo);

        Lesson tmp = DataBaseOperation.GetNextLessonByUser();
        if(tmp!=null)
        {
            tv_nextLessonNull.setVisibility(View.GONE);
            nextLessonInfo.setVisibility(View.VISIBLE);
            tv_nextLessonName.setText(DataBaseOperation.GetSubjectById(tmp.getSubjectId()).getName());
        }else
        {
            tv_nextLessonNull.setVisibility(View.VISIBLE);
            nextLessonInfo.setVisibility(View.GONE);
        }

        if (DataBaseOperation.GetTodayLessonByUser().size()<=0)
        {
            tv_TodayLessonsNull.setVisibility(View.VISIBLE);
            lv_TodayLessons.setVisibility(View.GONE);
        }else {
            tv_TodayLessonsNull.setVisibility(View.GONE);
            lv_TodayLessons.setVisibility(View.VISIBLE);
            lessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item, DataBaseOperation.GetTodayLessonByUser());
            lv_TodayLessons.setAdapter(lessonsListAdapter);
        }
        return root;
    }

    @Override
    public void Notify() {
        lessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item, DataBaseOperation.GetTodayLessonByUser());
        lv_TodayLessons.setAdapter(lessonsListAdapter);
    }




}