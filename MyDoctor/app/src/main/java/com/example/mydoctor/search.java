package com.example.mydoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class search extends AppCompatActivity {

    Button btnget;

    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //SearchView start
        mySearchView = (SearchView)findViewById(R.id.searchView);
        myList = (ListView)findViewById(R.id.myList);

        list = new ArrayList<String>();

        list.add("Monday");
        list.add("tt");
        list.add("g");
        list.add("cdc");
        list.add("hh");
        list.add("grf");
        list.add("rgf");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
               @Override
            public boolean onQueryTextSubmit(String s){
                   return false;
               }

               @Override
            public boolean onQueryTextChange(String s){

                   adapter.getFilter().filter(s);

                   return false;
               }
        });


        //searchView end

        btnget = (Button) findViewById(R.id.see);
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(search.this,doctorsSlide.class);
                startActivity(a);
            }
        });


        //floating menu start
        final FloatingActionButton fab1 = findViewById(R.id.fab_actionhome);
        fab1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                home(fab1);
            }
        });

        final FloatingActionButton fab2 = findViewById(R.id.fab_actiondepartment);
        fab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                department(fab2);
            }
        });

        final FloatingActionButton fab3 = findViewById(R.id.fab_actionqoutes);
        fab3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                qoutes(fab3);
            }
        });

        final FloatingActionButton fab4 = findViewById(R.id.fab_actioncontact);
        fab4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                contact(fab4);
            }
        });

        final FloatingActionButton fab5 = findViewById(R.id.fab_actionabout);
        fab5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                about(fab5);
            }
        });

        final FloatingActionButton fab6 = findViewById(R.id.fab_actionsearch);
        fab6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                search(fab6);
            }
        });
        //floating menu end

    }

    public void home(View view) {
        Intent a = new Intent(this, Home.class);
        startActivity(a);
    }
    public void department(View View) {
        Intent a = new Intent(this, doctorsSlide.class);
        startActivity(a);
    }
    public void qoutes(View view) {
        Intent a = new Intent(this,qoutes.class);
        startActivity(a);
    }

    public void about(View view) {
        Intent a = new Intent(this,about.class);
        startActivity(a);
    }

    public void contact(View view) {
        Intent a = new Intent(this,MainActivity.class);
        startActivity(a);
    }

    public void search(View view) {
        Intent a = new Intent(this,search.class);
        startActivity(a);
    }


}
