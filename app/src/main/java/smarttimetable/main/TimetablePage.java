package smarttimetable.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import smarttimetable.main.Model.DBModels.Course;
import smarttimetable.main.Model.DBModels.Group;
import smarttimetable.main.Model.DBModels.GroupForView;
import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.windows.LessonsListAdapter;


public class TimetablePage extends Fragment {


    private GroupForView groupForView;

    private ArrayList<Lesson> lessons = new ArrayList<>();
    private int pageNumber;

    ListView lv_firstDay;
    ListView lv_secondDay;
    ListView lv_thirdDay;
    ListView lv_fourthDay;
    ListView lv_fifthDay;
    ListView lv_sixthDay;

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
        //TextView pageHeader=(TextView)result.findViewById(R.id.testText);
        String header = groupForView.group.getName()+" "+groupForView.course.getNumber();
        //pageHeader.setText(header);

        lv_firstDay = (ListView)result.findViewById(R.id.rv_FirstDay);
        lv_secondDay = (ListView) result.findViewById(R.id.rv_SecondDay);
        lv_thirdDay = (ListView) result.findViewById(R.id.rv_ThirdDay);
        lv_fourthDay = (ListView) result.findViewById(R.id.rv_FourthDay);
        lv_fifthDay = (ListView) result.findViewById(R.id.rv_FifthDay);
        lv_sixthDay = (ListView) result.findViewById(R.id.rv_SixthDay);

       // Log.println(Log.INFO,"SIZESIZESIZESIZE",String.valueOf(DataBaseOperation.GetLessonsByDay(lessons,DataBase.Days.get(0)).size()));

        LessonsListAdapter FirstDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(lessons,DataBase.Days.get(0)));
        LessonsListAdapter SecondDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(lessons,DataBase.Days.get(1)));
        LessonsListAdapter ThirdDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(lessons,DataBase.Days.get(2)));
        LessonsListAdapter FourthDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(lessons,DataBase.Days.get(3)));
        LessonsListAdapter FifthDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(lessons,DataBase.Days.get(4)));
        LessonsListAdapter SixthDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(lessons,DataBase.Days.get(5)));
        // устанавливаем адаптер
        lv_firstDay.setAdapter(FirstDayLessonsListAdapter);
        lv_secondDay.setAdapter(SecondDayLessonsListAdapter);
        lv_thirdDay.setAdapter(ThirdDayLessonsListAdapter);
        lv_fourthDay.setAdapter(FourthDayLessonsListAdapter);
        lv_fifthDay.setAdapter(FifthDayLessonsListAdapter);
        lv_sixthDay.setAdapter(SixthDayLessonsListAdapter);

        return result;
    }

    private void GetLessons()
    {
        for (int i = 0;i<DataBase.CurrentWeekLessons.size();i++)
        {
            //Log.println(Log.INFO,"gggggggggggggggggggggg",String.valueOf(DataBase.CurrentWeekLessons.get(i).getCourseId())+" == "+String.valueOf(groupForView.course.getIdcourse()));
            if (DataBase.CurrentWeekLessons.get(i).getCourseId() == groupForView.course.getIdcourse() && DataBase.CurrentWeekLessons.get(i).getGroupId() == groupForView.group.getIdgroup())
            {
                lessons.add(DataBase.CurrentWeekLessons.get(i));
            }
        }



    }
}