package smarttimetable.main.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import smarttimetable.main.Model.CacheModels.Cache;
import smarttimetable.main.Model.DBModels.Course;
import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DBModels.Subject;
import smarttimetable.main.Model.DBModels.Teacher;
import smarttimetable.main.Model.DBModels.Week;

public class TimetableChangeNotifier {
    private static ArrayList<String> ChangeList = new ArrayList<>();



    public static ArrayList<String> Check()
    {
        CheckTeachers();
        CheckSubjects();
        if (!CheckWeeks())
        {
            CheckLessons();
        }
        return ChangeList;
    }





    private static void CheckLessons()
    {
        List<Lesson> cache = Cache.ReadLessons();

        List<Lesson> db = (List<Lesson>) DataBase.SelectedWeeksLessons.clone();

        for (int i = 0; i < cache.size(); i++) {
            if (DataBaseOperation.GetLessonById(cache.get(i).getIdtimetable()) == null)
            {
                ChangeList.add("Удален урок "+cache.get(i).toString());
            }else if(!DataBaseOperation.GetLessonById(cache.get(i).getIdtimetable()).equals(cache.get(i)))
            {
                ChangeList.add("Изменен урок "+cache.get(i).toString());
                for (int j = 0; j < db.size(); j++) {
                    if (db.get(j).getIdtimetable()==cache.get(i).getIdtimetable())
                    {
                        db.remove(j);
                        break;
                    }
                }
            }else{
                for (int j = 0; j < db.size(); j++) {
                    if (db.get(j).getIdtimetable()==cache.get(i).getIdtimetable())
                    {
                        db.remove(j);
                        break;
                    }
                }
            }
        }

        if (db.size()!=0)
        {
            for (int i = 0; i < db.size(); i++) {
                ChangeList.add("Добавлен урок "+db.get(i).toString());
            }
        }
    }

    private static void CheckSubjects()
    {
        List<Subject> cache = Cache.ReadSubjects();

        List<Subject> db = (List<Subject>) DataBase.Subjects.clone();

        for (int i = 0; i < cache.size(); i++) {
            if (DataBaseOperation.GetSubjectById(cache.get(i).getIdsubject()) == null)
            {
                ChangeList.add("Удален предмет "+cache.get(i).getName());
            }else if(!DataBaseOperation.GetSubjectById(cache.get(i).getIdsubject()).equals(cache.get(i)))
            {
                ChangeList.add("Изменен предмет "+cache.get(i).getName());
                for (int j = 0; j < db.size(); j++) {
                    if (db.get(j).getIdsubject()==cache.get(i).getIdsubject())
                    {
                        db.remove(j);
                        break;
                    }
                }
            }else{
                for (int j = 0; j < db.size(); j++) {
                    if (db.get(j).getIdsubject()==cache.get(i).getIdsubject())
                    {
                        db.remove(j);
                        break;
                    }
                }
            }
        }

        if (db.size()!=0)
        {
            for (int i = 0; i < db.size(); i++) {
                ChangeList.add("Добавлен предмет "+db.get(i).getName());
            }
        }

    }

    private static void CheckTeachers()
    {
        List<Teacher> cache = Cache.ReadTeachers();

        List<Teacher> db = (List<Teacher>) DataBase.Teachers.clone();
        debug.log("dbSIZE",db.size());

        debug.log("cacheteavher",cache.get(0).getName());

        for (int i = 0; i < cache.size(); i++) {
            if (DataBaseOperation.GetTeacherById(cache.get(i).getIdTeacher()) == null)
            {
                ChangeList.add("Удален преподаватель "+cache.get(i).getName());
            }else if(!DataBaseOperation.GetTeacherById(cache.get(i).getIdTeacher()).equals(cache.get(i)))
            {
                ChangeList.add("Изменен преподаватель "+cache.get(i).getName());
                for (int j = 0; j < db.size(); j++) {
                    if (db.get(j).getIdTeacher()==cache.get(i).getIdTeacher())
                    {
                        db.remove(j);
                        break;
                    }
                }
            }else{
                for (int j = 0; j < db.size(); j++) {
                    if (db.get(j).getIdTeacher()==cache.get(i).getIdTeacher())
                    {
                        db.remove(j);
                        break;
                    }
                }
            }
        }

        if (db.size()!=0)
        {
            for (int i = 0; i < db.size(); i++) {
                ChangeList.add("Добавлен преподаватель "+db.get(i).getName());
            }
        }
    }

    private static boolean CheckWeeks()
    {
        List<Week> cache = Cache.ReadWeeks();

        List<Week> db = (List<Week>) DataBase.Weeks.clone();

        if (!cache.get(cache.size()-1).equals(db.get(db.size()-1)))
        {
            ChangeList.add("Добавлена новая неделя "+db.get(db.size()-1).toString());
            return true;
        }
        return false;

    }

}
