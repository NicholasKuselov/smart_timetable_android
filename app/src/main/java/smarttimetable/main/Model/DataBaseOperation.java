package smarttimetable.main.Model;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

import smarttimetable.main.JSONController;
import smarttimetable.main.Model.DBModels.*;
import smarttimetable.main.Model.WebModel.API;
import smarttimetable.main.Model.WebModel.RequestHandler;


public class DataBaseOperation {

    public static Group GetGroupById(int id)
    {
        for (int i = 0; i < DataBase.Groups.size(); i++)
        {
            if (DataBase.Groups.get(i).getIdgroup() == id)
            {
                return DataBase.Groups.get(i);
            }
        }
        return null;
    }

    public static Subject GetSubjectById(int id)
    {
        for (int i = 0; i < DataBase.Subjects.size(); i++)
        {
            if (DataBase.Subjects.get(i).getIdsubject() == id)
            {
                return DataBase.Subjects.get(i);
            }
        }
        return null;
    }

    public static Teacher GetTeacherById(int id)
    {
        for (int i = 0; i < DataBase.Teachers.size(); i++)
        {
            if (DataBase.Teachers.get(i).getIdTeacher() == id)
            {
                return DataBase.Teachers.get(i);
            }
        }
        return null;
    }

    public static Day GetDayById(int id)
    {
        for (int i = 0; i < DataBase.Days.size(); i++)
        {
            if (DataBase.Days.get(i).getIdDay() == id)
            {
                return DataBase.Days.get(i);
            }
        }
        return null;
    }

    public static Course GetCourseById(int id)
    {
        for (int i = 0; i < DataBase.Courses.size(); i++)
        {
            if (DataBase.Courses.get(i).getIdcourse() == id)
            {
                return DataBase.Courses.get(i);
            }
        }
        return null;
    }

    public static Week GetWeekById(int id)
    {
        for (int i = 0; i < DataBase.Weeks.size(); i++)
        {
            if (DataBase.Weeks.get(i).getIdweek() == id)
            {
                return DataBase.Weeks.get(i);
            }
        }
        return null;
    }

    public static void CreateGroupsForView()
    {
        for(int i = 0; i < DataBase.Courses.size(); i++)
        {
            for(int j = 0; j < DataBase.Groups.size(); j++)
            {
                DataBase.GroupsForView.add(new GroupForView(DataBase.Groups.get(j),DataBase.Courses.get(i)));
            }
        }
    }

    public static void ConnectToDb()
    {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.println(Log.INFO,"tessss",RequestHandler.sendGetRequest(API.URL_GET_Weeks));
                DataBase.Weeks = new ArrayList<>(JSONController.importWeeksFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Weeks)));
                DataBase.Days = new ArrayList<>(JSONController.importDaysFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Days)));
                DataBase.Groups = new ArrayList<>(JSONController.importGroupsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Groups)));
                DataBase.Courses = new ArrayList<>(JSONController.importCoursesFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Courses)));
                DataBase.Subjects = new ArrayList<>(JSONController.importSubjectsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Subjects)));
                DataBase.Teachers = new ArrayList<>(JSONController.importTeachersFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Teacher)));
                DataBase.currentWeek = DataBase.Weeks.get(DataBase.Weeks.size()-1);
                DataBaseOperation.CreateGroupsForView();
                Log.println(Log.INFO,"One",API.URL_GET_LessonsByWeekId+DataBase.currentWeek.getIdweek());
                Log.println(Log.INFO,"Two",RequestHandler.sendGetRequest(API.URL_GET_LessonsByWeekId+DataBase.currentWeek.getIdweek()).toString());
                DataBase.CurrentWeekLessons = new ArrayList<>(JSONController.importLessonsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_LessonsByWeekId+DataBase.currentWeek.getIdweek()).toString()));
            }
        });


    }
}
