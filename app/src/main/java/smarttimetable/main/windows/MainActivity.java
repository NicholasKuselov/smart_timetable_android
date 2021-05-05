package smarttimetable.main.windows;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import smarttimetable.main.Model.CacheModels.Cache;
import smarttimetable.main.Model.DBModels.DataBaseConnector;
import smarttimetable.main.Model.IFragmentNotifier;
import smarttimetable.main.fragments.SettingsFragment;
import smarttimetable.main.setting.*;
import smarttimetable.main.Model.TimetableChangeNotifier;
import smarttimetable.main.R;
import smarttimetable.main.fragments.AllLessonsIFragment;
import smarttimetable.main.fragments.HomeIFragment;
import smarttimetable.main.fragments.TimetableIFragment;
import smarttimetable.main.fragments.UserLessonsIFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , DataBaseConnector.DataBaseConnectorListener {


    private ArrayList<String> ChangeLog;

    private IFragmentNotifier CurrentFragment;

    private HomeIFragment fg_home;
    private TimetableIFragment fg_timetable;
    private AllLessonsIFragment fg_allLessons;
    private UserLessonsIFragment fg_UserLessons;

    Toolbar toolbar;

    Button b_NoConnetion;

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_NoConnetion = (Button)findViewById(R.id.b_NoConnectionButton);
        b_NoConnetion.setVisibility(View.GONE);

        Setting.CreateSetting(this);
        Setting.SetUser(3,5); //ipz 1
        Cache.context = this;

        CreateFragments();


        Connect();


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home,R.id.nav_timetable, R.id.nav_all_lessons, R.id.nav_user_lessons).setDrawerLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);


        try {
            HomeIFragment tmp = HomeIFragment.class.newInstance();
            CurrentFragment = tmp;
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, tmp).commit();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void OnConnected(DataBaseConnector.ConnectionResult connectionResult)
    {
        switch (connectionResult)
        {
            case NoConnection:
                b_NoConnetion.setVisibility(View.VISIBLE);
                break;

            case Success:
                b_NoConnetion.setVisibility(View.GONE);
                ChangeLog = TimetableChangeNotifier.Check();
                if (ChangeLog.size()>0)
                {
                    String aaa = "";
                    for (int i = 0; i < ChangeLog.size() ; i++) {
                        aaa = aaa + ChangeLog.get(i) + "\n";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setMessage(aaa).setTitle(R.string.ChangeDialogTitle);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    CurrentFragment.Notify();
                    Cache.Write();
                }
                break;

            case Error:
                break;
        }

    }

    public void OnConnectButtonClick(View v)
    {
        Connect();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;

        int id = item.getItemId();
        try {

            switch (id) {
                case R.id.nav_timetable:
                    TimetableIFragment tmp = TimetableIFragment.class.newInstance();
                    CurrentFragment = tmp;
                    fragment = tmp;
                    break;
                case R.id.nav_home:
                    HomeIFragment tmp1 = HomeIFragment.class.newInstance();
                    CurrentFragment = tmp1;
                    fragment = tmp1;
                    break;
                    /*
                case R.id.nav_all_lessons:
                    AllLessonsFragment tmp2 = AllLessonsFragment.class.newInstance();
                    CurrentFragment = tmp2;
                    fragment = tmp2;
                    break;

                     */
                case R.id.nav_user_lessons:
                    UserLessonsIFragment tmp3 = UserLessonsIFragment.class.newInstance();
                    CurrentFragment = tmp3;
                    fragment = tmp3;
                    break;

                case R.id.nav_setting:
                    SettingsFragment tmp4 = SettingsFragment.class.newInstance();
                    CurrentFragment = tmp4;
                    fragment = tmp4;
                    break;

            }
        }catch (Exception e){

        }

        // Вставляем фрагмент, заменяя текущий фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке

        toolbar.setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }


    private void CreateFragments()
    {
        try {
            fg_allLessons = AllLessonsIFragment.class.newInstance();
            fg_home = HomeIFragment.class.newInstance();
            fg_timetable = TimetableIFragment.class.newInstance();
            fg_UserLessons = UserLessonsIFragment.class.newInstance();
        }catch (Exception e)
        {

        }
    }

    private void Connect()
    {
        DataBaseConnector dataBaseConnector = new DataBaseConnector(this);
        dataBaseConnector.execute();
    }

}