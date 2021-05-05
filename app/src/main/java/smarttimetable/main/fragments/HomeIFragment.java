package smarttimetable.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.IFragmentNotifier;
import smarttimetable.main.Model.LessonsListAdapter;
import smarttimetable.main.R;


public class HomeIFragment extends Fragment implements IFragmentNotifier {

    ListView lv_TodayLessons;
    LessonsListAdapter lessonsListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_home, container, false);

        lv_TodayLessons = (ListView)result.findViewById(R.id.lv_LessonsToday);
        lessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item, DataBaseOperation.GetTodayLessonByUser());
        lv_TodayLessons.setAdapter(lessonsListAdapter);

        return result;
    }

    @Override
    public void Notify() {
        lessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item, DataBaseOperation.GetTodayLessonByUser());
        lv_TodayLessons.setAdapter(lessonsListAdapter);
    }




}