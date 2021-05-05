package smarttimetable.main.Model.DBModels;

import android.os.AsyncTask;

import java.util.ArrayList;

import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.JSONController;
import smarttimetable.main.Model.WebModel.API;
import smarttimetable.main.Model.WebModel.RequestHandler;

public class DataBaseConnector extends AsyncTask<Void,Void , DataBaseConnector.ConnectionResult> {

    private DataBaseConnectorListener callback;

    public DataBaseConnector(final DataBaseConnectorListener callback) {
        this.callback = callback;
    }

    @Override
    protected DataBaseConnector.ConnectionResult doInBackground(Void... arg0) {
        try {
            if (!RequestHandler.isOnline()) {
                return ConnectionResult.NoConnection;
            }
            DataBase.Weeks = new ArrayList<>(JSONController.importWeeksFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Weeks)));
            DataBase.Days = new ArrayList<>(JSONController.importDaysFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Days)));
            DataBase.Groups = new ArrayList<>(JSONController.importGroupsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Groups)));
            DataBase.Courses = new ArrayList<>(JSONController.importCoursesFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Courses)));
            DataBase.Subjects = new ArrayList<>(JSONController.importSubjectsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Subjects)));
            DataBase.Teachers = new ArrayList<>(JSONController.importTeachersFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Teacher)));
            DataBase.currentWeek = DataBase.Weeks.get(0);
            DataBaseOperation.CreateGroupsForView();
            // DataBase.CurrentWeekLessons = new ArrayList<>(JSONController.importLessonsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_LessonsByWeekId + DataBase.currentWeek.getIdweek()).toString()));
            DataBase.SelectedWeeksLessons.clear();
            for (int i = 0; i < DataBase.Weeks.size(); i++) {
                DataBase.SelectedWeeksLessons.addAll(JSONController.importLessonsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_LessonsByWeekId + DataBase.Weeks.get(i).getIdweek()).toString()));
            }

            return ConnectionResult.Success;
        }catch (Exception e)
        {
            return ConnectionResult.Error;
        }
    }

    @Override
    protected void onPostExecute(ConnectionResult result) {
        if(callback!=null)
            callback.OnConnected(result);
    }

    public interface DataBaseConnectorListener
    {
        public void OnConnected(ConnectionResult someResult);
    }

    public enum ConnectionResult
    {
        NoConnection,
        Error,
        Success

    };
}
