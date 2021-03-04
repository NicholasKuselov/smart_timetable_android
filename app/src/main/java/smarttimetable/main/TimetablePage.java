package smarttimetable.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import smarttimetable.main.Model.DBModels.Course;
import smarttimetable.main.Model.DBModels.Group;
import smarttimetable.main.Model.DBModels.GroupForView;
import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimetablePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimetablePage extends Fragment {


    private GroupForView groupForView;

    private ArrayList<Lesson> lessons = new ArrayList<>();
    private int pageNumber;

    public TimetablePage() {
        // Required empty public constructor
    }

    public static TimetablePage newInstance(int page) {
        TimetablePage fragment = new TimetablePage();

        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
        groupForView = DataBase.GroupsForView.get(pageNumber);
        GetLessons();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_timetable_page, container, false);
        TextView pageHeader=(TextView)result.findViewById(R.id.testText);
        String header = groupForView.group.getName()+" "+groupForView.course.getNumber();
        pageHeader.setText(header);

        return result;
    }

    private void GetLessons()
    {
        for (int i = 0;i<DataBase.CurrentWeekLessons.size();i++)
        {
            if (DataBase.CurrentWeekLessons.get(i).getCourseId() == groupForView.course.getIdcourse() && DataBase.CurrentWeekLessons.get(i).getGroupId() == groupForView.group.getIdgroup())
            {
                lessons.add((DataBase.CurrentWeekLessons.get(i)));
            }
        }

    }
}