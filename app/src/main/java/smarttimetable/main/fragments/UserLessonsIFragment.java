package smarttimetable.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import smarttimetable.main.Model.DBModels.GroupForView;
import smarttimetable.main.Model.IFragmentNotifier;
import smarttimetable.main.R;


public class UserLessonsIFragment extends Fragment implements IFragmentNotifier {

    @Override
    public void Notify() {

    }

    private GroupForView groupForView;

    private int pageNumber;

    ListView lv_firstDay;
    ListView lv_secondDay;
    ListView lv_thirdDay;
    ListView lv_fourthDay;
    ListView lv_fifthDay;
    ListView lv_sixthDay;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_user_lessons, container, false);


        return root;
    }
}