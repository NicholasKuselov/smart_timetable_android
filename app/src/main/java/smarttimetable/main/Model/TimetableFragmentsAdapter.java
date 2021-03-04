package smarttimetable.main.Model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.TimetablePage;
import smarttimetable.main.windows.TimetableFragment;

public class TimetableFragmentsAdapter extends FragmentStateAdapter {

    public TimetableFragmentsAdapter(TimetableFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return(TimetablePage.newInstance(position));
    }

    @Override
    public int getItemCount() {
        return DataBase.GroupsForView.size();
    } //???????????????????????//
}
