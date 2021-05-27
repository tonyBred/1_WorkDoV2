package com.example.workdoRoom;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.view.Menu;
import android.view.MenuItem;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    public TugasViewModel tugasViewModel;

    public void setTugasViewModel(TugasViewModel tugasViewModel){
        this.tugasViewModel = tugasViewModel;
    }

    public TugasViewModel getTugasViewModel(){
        return this.tugasViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tugasViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(TugasViewModel.class);
        //tugasViewModel.deleteAll();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new FirstFragment()).commit();

        BottomNavigationView bottomNavigation  = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_upcoming:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new FirstFragment()).commit();
                        break;
                    case R.id.action_overdue:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new SecondFragment()).commit();
                        break;
                    case R.id.action_add:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new ThirdFragment()).commit();
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}