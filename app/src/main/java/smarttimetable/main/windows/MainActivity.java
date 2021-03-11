package smarttimetable.main.windows;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import smarttimetable.main.Model.CacheModels.Cache;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.TimetableChangeNotifier;
import smarttimetable.main.R;
import smarttimetable.main.fragments.AllLessonsFragment;
import smarttimetable.main.fragments.HomeFragment;
import smarttimetable.main.fragments.TimetableFragment;
import smarttimetable.main.fragments.TimetablePage;
import smarttimetable.main.fragments.UserLessonsFragment;
import smarttimetable.main.fragments.WeekFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //public ArrayList<Lesson> LessonsMas = new ArrayList<Lesson>();

    public void onttt(View view)
    {
       // Toast.makeText(this,"sssss",Toast.LENGTH_LONG);
        Log.println(Log.INFO,"Click","Clck");
    }

    Button b_NoConnetion;

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.DarkTheme);
        super.onCreate(savedInstanceState);
        b_NoConnetion = (Button)findViewById(R.id.b_NoConnectionButton);
        setContentView(R.layout.activity_main);

        //JSONController.testJson(this);
        Cache.context = this;

        DataBaseOperation.ConnectToDb();
        ((Button)findViewById(R.id.b_NoConnectionButton)).setHeight(0);
      /*
        if(!DataBaseOperation.ConnectToDb())
        {
            b_NoConnetion.setHeight(40);
            Cache.Read(this);
        }
        else {
            ((Button)findViewById(R.id.b_NoConnectionButton)).setHeight(0);
            TimetableChangeNotifier.Check();
            DataBaseOperation.ConnectToDb();

        }


       */



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home,R.id.nav_timetable, R.id.nav_all_lessons, R.id.nav_user_lessons).setDrawerLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass = null;


        int id = item.getItemId();

        switch (id)
        {
            case R.id.nav_timetable:
                fragmentClass = TimetableFragment.class;
                break;
            case R.id.nav_home:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_all_lessons:
                fragmentClass = AllLessonsFragment.class;
                break;
            case R.id.nav_user_lessons:
                fragmentClass = UserLessonsFragment.class;
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Вставляем фрагмент, заменяя текущий фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }


    public void UpdateTimetable()
    {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, TimetableFragment.class.newInstance()).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}