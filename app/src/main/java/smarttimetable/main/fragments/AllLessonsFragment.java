package smarttimetable.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import smarttimetable.main.Model.FragmentNotifier;
import smarttimetable.main.Model.debug;
import smarttimetable.main.R;


public class AllLessonsFragment extends Fragment implements FragmentNotifier {
    @Override
    public void Notify() {
        debug.log("Notify Work","AllLessonsFragment");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_all_lessons, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);

        return root;
    }
}