package smarttimetable.main.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import smarttimetable.main.Model.DBModels.Course;
import smarttimetable.main.Model.DBModels.Group;
import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.IFragmentNotifier;
import smarttimetable.main.R;
import smarttimetable.main.setting.Setting;

public class SettingsFragment extends Fragment implements IFragmentNotifier {

    ArrayAdapter<Group> sp_groupAdapter;
    ArrayAdapter<Course> sp_coursesAdapter;

    private int userGroupId = -1;
    private int userCourseId = -1;

    public SettingsFragment() {

    }

    public void OnSaveButtonClick(View v)
    {
        if(userCourseId == -1 || userGroupId == -1)
        {
            return;
        }
        Setting.SetUser(userGroupId,userCourseId);
    }

    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        Spinner sp_groups = (Spinner)root.findViewById(R.id.sp_groups);
        sp_groupAdapter = new ArrayAdapter<Group>(this.getActivity(), R.layout.week_spinner, DataBase.Groups);
        sp_groupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_groups.setAdapter(sp_groupAdapter);

        //if (currentWeekPos!=-1) spinner.setSelection(currentWeekPos);
        //spinner.setSelection();
        AdapterView.OnItemSelectedListener sp_groupItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userGroupId = DataBase.Groups.get(position).getIdgroup();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        sp_groups.setOnItemSelectedListener(sp_groupItemSelectedListener);




        Spinner sp_courses = (Spinner)root.findViewById(R.id.sp_courses);
        sp_coursesAdapter = new ArrayAdapter<Course>(this.getActivity(), R.layout.week_spinner, DataBase.Courses);
        sp_coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_courses.setAdapter(sp_coursesAdapter);

        //if (currentWeekPos!=-1) spinner.setSelection(currentWeekPos);
        //spinner.setSelection();

        AdapterView.OnItemSelectedListener sp_coursesItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userCourseId = DataBase.Courses.get(position).getIdcourse();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        sp_courses.setOnItemSelectedListener(sp_coursesItemSelectedListener);

        return root;
    }

    @Override
    public void Notify() {

    }
}