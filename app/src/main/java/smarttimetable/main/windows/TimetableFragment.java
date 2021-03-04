package smarttimetable.main.windows;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.TimetableFragmentsAdapter;
import smarttimetable.main.R;

public class TimetableFragment extends Fragment {



    public TimetableFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_timetable, container, false);

        ViewPager2 pager=(ViewPager2)root.findViewById(R.id.pager);
        FragmentStateAdapter pageAdapter = new TimetableFragmentsAdapter(this);
        pager.setAdapter(pageAdapter);

        return root;
    }
}