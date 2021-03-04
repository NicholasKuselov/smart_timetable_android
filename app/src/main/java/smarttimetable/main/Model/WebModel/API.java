package smarttimetable.main.Model.WebModel;

public class API {
    private static final String ROOT_URL = "http://b80994.hostua01.fornex.org/SmartTimetableAPI/v1/Api.php?apicall=";

    public static final String URL_GET_Lessons = ROOT_URL + "getLessons";
    public static final String URL_GET_LessonsByWeekId = ROOT_URL + "getLessons&weekid=";
    public static final String URL_GET_Groups = ROOT_URL + "getGroups";
    public static final String URL_GET_Teacher = ROOT_URL + "getTeacher";
    public static final String URL_GET_Subjects = ROOT_URL + "getSubjects";
    public static final String URL_GET_Days = ROOT_URL + "getDays";
    public static final String URL_GET_Courses = ROOT_URL + "getCourses";
    public static final String URL_GET_Weeks = ROOT_URL + "getWeeks";

}
