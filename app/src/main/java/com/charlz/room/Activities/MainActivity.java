package com.charlz.room.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.charlz.room.Adapter.MovieAdapter;
import com.charlz.room.Classes.AppDatabase;
import com.charlz.room.Classes.Movies;
import com.charlz.room.R;
import com.charlz.room.Threads.Thread;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MovieAdapter adapter;
    List<Movies> movies;
    FloatingActionButton fab;
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv=findViewById(R.id.recycler);
        adapter = new MovieAdapter(movies);
        rv.setLayoutManager(new LinearLayoutManager(this));

        db = AppDatabase.getAppDataBase(getApplicationContext());
        movies = db.moviesDAO().getALL();

        Thread hilo = new Thread(movies,rv,adapter,db);
        hilo.execute();

        fab  = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateMovie.class));
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
