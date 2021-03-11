package smarttimetable.main.Model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

import smarttimetable.main.fragments.TimetablePage;
import smarttimetable.main.fragments.TimetableFragment;

public class TimetableFragmentsAdapter extends FragmentStateAdapter {

    public ArrayList<TimetablePage> pages = new ArrayList<>();

    public TimetableFragmentsAdapter(TimetableFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        TimetablePage page = TimetablePage.newInstance(position);
        pages.add(page);
        return(page);
    }

    @Override
    public int getItemCount() {
        return DataBase.GroupsForView.size();
    }

    public void uu()
    {
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
