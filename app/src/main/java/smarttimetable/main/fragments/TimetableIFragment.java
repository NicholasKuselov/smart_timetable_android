package smarttimetable.main.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.DateTimeOperation;
import smarttimetable.main.Model.IFragmentNotifier;
import smarttimetable.main.Model.TimetableFragmentsAdapter;
import smarttimetable.main.Model.debug;
import smarttimetable.main.R;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class TimetableIFragment extends Fragment implements IFragmentNotifier {
    @Override
    public void Notify() {
        debug.log("Notify Work","TimetableFragment");
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(DataBase.GroupsForView.get(position).GetAbbreviation());
            }
        });
        tabLayoutMediator.attach();
        Update();
    }

    ArrayAdapter<Week> adapter;
    ViewPager2 pager;
    TimetableFragmentsAdapter pageAdapter;
    TabLayout tabLayout;

    public TimetableIFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_timetable, container, false);
        Spinner spinner = (Spinner) root.findViewById(R.id.sp_Week);
        adapter = new ArrayAdapter<Week>(this.getActivity(), R.layout.week_spinner, DataBase.Weeks);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        pager=(ViewPager2)root.findViewById(R.id.pager);
        pageAdapter = new TimetableFragmentsAdapter(this);
        pager.setAdapter(pageAdapter);



        tabLayout = root.findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(DataBase.GroupsForView.get(position).GetAbbreviation());
            }
        });
        tabLayoutMediator.attach();

        int currentWeekPos = DateTimeOperation.GetCurrentWeekPos();
        if (currentWeekPos!=-1) spinner.setSelection(currentWeekPos);
        //spinner.setSelection();

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DataBase.currentWeek = DataBase.Weeks.get(position);
                DataBaseOperation.SetCurrentWeek(DataBase.Weeks.get(position));

                Update();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


        return root;
    }


    void Update()
    {
        //pageAdapter.uu();

        pageAdapter = new TimetableFragmentsAdapter(this);

        pager.setAdapter(pageAdapter);

    }

    public static TimetableIFragment newInstance(int page) {
        TimetableIFragment fragment = new TimetableIFragment();

        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;


    }

}