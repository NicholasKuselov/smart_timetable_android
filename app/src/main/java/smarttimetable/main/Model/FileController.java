package smarttimetable.main.Model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import smarttimetable.main.Model.DBModels.Week;

public class FileController {
    public static String ReadFile(Context context,String path)
    {
        String result = "";
        InputStreamReader streamReader = null;
        try {
            streamReader = new InputStreamReader(context.openFileInput(path));


            int c;
            while((c = streamReader.read())!=-1){
                result = result + (char)c;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }



    public static boolean WriteFile(Context context,String FilePath, String Content)
    {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = context.openFileOutput(FilePath, Context.MODE_PRIVATE);
            fileOutputStream.write(Content.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
