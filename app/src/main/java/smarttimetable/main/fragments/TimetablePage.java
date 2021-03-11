package smarttimetable.main.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import smarttimetable.main.Model.DBModels.GroupForView;
import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.DateTimeOperation;
import smarttimetable.main.Model.debug;
import smarttimetable.main.R;
import smarttimetable.main.Model.LessonsListAdapter;


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

    /*
    public void setSelectedItem() {
        //Toast.makeText(this.getActivity(),"yesssss",Toast.LENGTH_LONG);
        FirstDayLessonsListAdapter.update(DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourse(groupForView),DataBase.Days.get(0)));
        SecondDayLessonsListAdapter.update(DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourse(groupForView),DataBase.Days.get(1)));
        ThirdDayLessonsListAdapter.update(DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourse(groupForView),DataBase.Days.get(2)));
        FourthDayLessonsListAdapter.update(DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourse(groupForView),DataBase.Days.get(3)));
        FifthDayLessonsListAdapter.update(DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourse(groupForView),DataBase.Days.get(4)));
        SixthDayLessonsListAdapter.update(DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourse(groupForView),DataBase.Days.get(5)));
    }

     */

    LessonsListAdapter FirstDayLessonsListAdapter;
    LessonsListAdapter SecondDayLessonsListAdapter;
    LessonsListAdapter ThirdDayLessonsListAdapter;
    LessonsListAdapter FourthDayLessonsListAdapter;
    LessonsListAdapter FifthDayLessonsListAdapter;
    LessonsListAdapter SixthDayLessonsListAdapter;

    TextView tv_FirstDay;
    TextView tv_SecondDay;
    TextView tv_ThirdDay;
    TextView tv_FourthDay;
    TextView tv_FifthDay;
    TextView tv_SixthDay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_timetable_page, container, false);

        String header = groupForView.group.getName()+" "+groupForView.course.getNumber();

        lv_firstDay = (ListView)result.findViewById(R.id.rv_FirstDay);
        lv_secondDay = (ListView) result.findViewById(R.id.rv_SecondDay);
        lv_thirdDay = (ListView) result.findViewById(R.id.rv_ThirdDay);
        lv_fourthDay = (ListView) result.findViewById(R.id.rv_FourthDay);
        lv_fifthDay = (ListView) result.findViewById(R.id.rv_FifthDay);
        lv_sixthDay = (ListView) result.findViewById(R.id.rv_SixthDay);

        tv_FirstDay = (TextView)result.findViewById(R.id.tv_FirstDay);
        tv_SecondDay = (TextView)result.findViewById(R.id.tv_SecondDay);
        tv_ThirdDay = (TextView)result.findViewById(R.id.tv_ThirdDay);
        tv_FourthDay = (TextView)result.findViewById(R.id.tv_FourthDay);
        tv_FifthDay = (TextView)result.findViewById(R.id.tv_FifthDay);
        tv_SixthDay = (TextView)result.findViewById(R.id.tv_SixthDay);

        FirstDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourseAndWeek(groupForView,DataBase.currentWeek),DataBase.Days.get(0)));
        SecondDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourseAndWeek(groupForView,DataBase.currentWeek),DataBase.Days.get(1)));
        ThirdDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourseAndWeek(groupForView,DataBase.currentWeek),DataBase.Days.get(2)));
        FourthDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourseAndWeek(groupForView,DataBase.currentWeek),DataBase.Days.get(3)));
        FifthDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourseAndWeek(groupForView,DataBase.currentWeek),DataBase.Days.get(4)));
        SixthDayLessonsListAdapter = new LessonsListAdapter(this.getActivity(), R.layout.lessons_list_item,DataBaseOperation.GetLessonsByDay(DataBaseOperation.GetLessonByGroupAndCourseAndWeek(groupForView,DataBase.currentWeek),DataBase.Days.get(5)));
        // устанавливаем адаптер
        lv_firstDay.setAdapter(FirstDayLessonsListAdapter);
        lv_secondDay.setAdapter(SecondDayLessonsListAdapter);
        lv_thirdDay.setAdapter(ThirdDayLessonsListAdapter);
        lv_fourthDay.setAdapter(FourthDayLessonsListAdapter);
        lv_fifthDay.setAdapter(FifthDayLessonsListAdapter);
        lv_sixthDay.setAdapter(SixthDayLessonsListAdapter);

        debug.log("adapter count",lv_firstDay.getAdapter().getCount());

        tv_FirstDay.setText(tv_FirstDay.getText()+" "+ DateTimeOperation.GetDayAfter(0,DataBase.currentWeek.getDateFrom()));
        tv_SecondDay.setText(tv_SecondDay.getText()+" "+ DateTimeOperation.GetDayAfter(1,DataBase.currentWeek.getDateFrom()));
        tv_ThirdDay.setText(tv_ThirdDay.getText()+" "+ DateTimeOperation.GetDayAfter(2,DataBase.currentWeek.getDateFrom()));
        tv_FourthDay.setText(tv_FourthDay.getText()+" "+ DateTimeOperation.GetDayAfter(3,DataBase.currentWeek.getDateFrom()));
        tv_FifthDay.setText(tv_FifthDay.getText()+" "+ DateTimeOperation.GetDayAfter(4,DataBase.currentWeek.getDateFrom()));
        tv_SixthDay.setText(tv_SixthDay.getText()+" "+ DateTimeOperation.GetDayAfter(5,DataBase.currentWeek.getDateFrom()));

        return result;
    }

    private void GetLessons()
    {
        /*
        for (int i = 0;i<DataBase.CurrentWeekLessons.size();i++)
        {
            //Log.println(Log.INFO,"gggggggggggggggggggggg",String.valueOf(DataBase.CurrentWeekLessons.get(i).getCourseId())+" == "+String.valueOf(groupForView.course.getIdcourse()));
            if (DataBase.CurrentWeekLessons.get(i).getCourseId() == groupForView.course.getIdcourse() && DataBase.CurrentWeekLessons.get(i).getGroupId() == groupForView.group.getIdgroup())
            {
                lessons.add(DataBase.CurrentWeekLessons.get(i));
            }
        }


         */


    }
}