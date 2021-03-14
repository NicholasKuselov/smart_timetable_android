package smarttimetable.main.setting;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Setting {
    private static SharedPreferences settings;
    private static SharedPreferences.Editor prefEditor;


    public static void CreateSetting(Context context)
    {
        settings = context.getSharedPreferences("main", MODE_PRIVATE);;
    }

    public static void SetUser(int groupId,int courseId)
    {

        prefEditor = settings.edit();

        prefEditor.putInt(SettingName.UserGroup,groupId);
        prefEditor.putInt(SettingName.UserCourse,courseId);

        prefEditor.apply();
    }

    public static int GetUserGroup()
    {
        return settings.getInt(SettingName.UserGroup, -1);
    }

    public static int GetUserCourse()
    {
        return settings.getInt(SettingName.UserCourse, -1);
    }
}
