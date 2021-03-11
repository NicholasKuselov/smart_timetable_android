package smarttimetable.main.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.TimetableFragmentsAdapter;
import smarttimetable.main.Model.WeekFragmentsAdapter;
import smarttimetable.main.R;


public class WeekFragment extends Fragment {

    ViewPager2 pager;
    WeekFragmentsAdapter pageAdapter;

    public WeekFragment() {

    }


    public static WeekFragment newInstance(int page) {
        WeekFragment fragment = new WeekFragment();

        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_week, container, false);

        pager=(ViewPager2)root.findViewById(R.id.week_pager);
        pageAdapter = new WeekFragmentsAdapter(this);
        pager.setAdapter(pageAdapter);

        final TabLayout tabLayout = root.findViewById(R.id.week_tab_layout);
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(DataBase.Weeks.get(position).getDateFrom());
            }
        });
        tabLayoutMediator.attach();
        return  root;
    }



}