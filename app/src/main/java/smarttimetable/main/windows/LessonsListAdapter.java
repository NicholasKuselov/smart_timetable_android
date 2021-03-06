package smarttimetable.main.windows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.R;

public class LessonsListAdapter extends ArrayAdapter<Lesson> {
    private LayoutInflater inflater;
    private int layout;
    private List<Lesson> lessons;

    public LessonsListAdapter(Context context, int resource, List<Lesson> lessons) {
        super(context, resource, lessons);
        this.lessons = lessons;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView tv_subject = (TextView) view.findViewById(R.id.tv_subject);
        TextView tv_teacher = (TextView) view.findViewById(R.id.tv_teacher);
        TextView tv_time = (TextView) view.findViewById(R.id.tv_time);

        Lesson lesson = lessons.get(position);

        tv_subject.setText(DataBaseOperation.GetSubjectById(lesson.getSubjectId()).getName());
        tv_teacher.setText(DataBaseOperation.GetTeacherById(lesson.getTeacherId()).getName());
        tv_time.setText(lesson.getTime());

        return view;
    }
}
