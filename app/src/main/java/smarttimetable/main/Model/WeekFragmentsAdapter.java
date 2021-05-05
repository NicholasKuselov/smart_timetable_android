package smarttimetable.main.Model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import smarttimetable.main.fragments.TimetableIFragment;
import smarttimetable.main.fragments.WeekFragment;

public class WeekFragmentsAdapter extends FragmentStateAdapter {


    public WeekFragmentsAdapter(WeekFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        TimetableIFragment page = TimetableIFragment.newInstance(position);
        return(page);
    }

    @Override
    public int getItemCount() {
        return DataBase.Weeks.size();
    }

}
