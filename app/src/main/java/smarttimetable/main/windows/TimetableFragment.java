package smarttimetable.main.windows;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.TimetableFragmentsAdapter;
import smarttimetable.main.R;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


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

        Spinner spinner = (Spinner) root.findViewById(R.id.sp_Week);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<Week> adapter = new ArrayAdapter<Week>(this.getActivity(), android.R.layout.simple_spinner_item, DataBase.Weeks);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        spinner.setSelection(2);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
               // String item = (String)parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


        ViewPager2 pager=(ViewPager2)root.findViewById(R.id.pager);
        FragmentStateAdapter pageAdapter = new TimetableFragmentsAdapter(this);
        pager.setAdapter(pageAdapter);

        TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(DataBase.GroupsForView.get(position).GetAbbreviation());
            }
        });
        tabLayoutMediator.attach();

        return root;
    }

    private class MyAdapter extends ArrayAdapter<Week> {

        public MyAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_2, DataBase.Weeks);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Week week = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(android.R.layout.simple_list_item_2, null);
            }
            ((TextView) convertView.findViewById(android.R.id.text1))
                    .setText(week.getDateFrom());
            ((TextView) convertView.findViewById(android.R.id.text2))
                    .setText(week.getDateTo());
            return convertView;
        }
    }
}