package smarttimetable.main.Model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

import smarttimetable.main.fragments.TimetableFragment;
import smarttimetable.main.fragments.TimetablePage;
import smarttimetable.main.fragments.WeekFragment;

public class WeekFragmentsAdapter extends FragmentStateAdapter {


    public WeekFragmentsAdapter(WeekFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        TimetableFragment page = TimetableFragment.newInstance(position);
        return(page);
    }

    @Override
    public int getItemCount() {
        return DataBase.Weeks.size();
    }

}
