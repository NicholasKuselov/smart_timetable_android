package smarttimetable.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import smarttimetable.main.Model.DBModels.DataBaseConnector;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.DateTimeOperation;
import smarttimetable.main.Model.FragmentNotifier;
import smarttimetable.main.Model.LessonsListAdapter;
import smarttimetable.main.Model.debug;
import smarttimetable.main.R;


public class HomeFragment extends Fragment implements DataBaseConnector.DataBaseConnectorListener, FragmentNotifier  {

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
        debug.log("Notify Work","HomeFragment");
    }

    @Override
    public void OnConnected(Void someResult) {
        debug.log("ffffffffff","yessssssssss");
        //lessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item, DataBaseOperation.GetTodayLessonByUser());

       // lv_TodayLessons.setAdapter(lessonsListAdapter);
    }


}