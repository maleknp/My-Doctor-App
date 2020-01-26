package com.example.mydoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class doctorSection extends AppCompatActivity {

    private ArrayList<CitiesItem> mCitiesList;
    private CitiesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_section);

        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("param"));

        //spinner section
        initList();

        Spinner spinnerCities = findViewById(R.id.cities);

        mAdapter = new CitiesAdapter(this, mCitiesList);
        spinnerCities.setAdapter(mAdapter);

        spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CitiesItem clickedItem = (CitiesItem) parent.getItemAtPosition(position);
                String clickedCitiesName = clickedItem.getcitiesName();
                Toast.makeText(doctorSection.this, clickedCitiesName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        doctors Cards loop
        ArrayList<doctorCard> arrayList = new ArrayList<doctorCard>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(new doctorCard("Mohameed mustafa" +i,"masara"+i,"0927971679"+i,"Tripoli"+i,"dhmany"+i,0));
        }



        ListView listView = findViewById(R.id.listView);
        doctrArrayAdapter arrayAdapter = new doctrArrayAdapter(this, R.layout.doctorcard, arrayList);
        listView.setAdapter(arrayAdapter);
        //end docrors Cards



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
    //floating menu end


    private void initList(){
        mCitiesList = new ArrayList<>();
        mCitiesList.add(new CitiesItem("All"));
        mCitiesList.add(new CitiesItem("Tripoli"));
        mCitiesList.add(new CitiesItem("Misurata"));
        mCitiesList.add(new CitiesItem("Bunghazi"));
        mCitiesList.add(new CitiesItem("Zawya"));
    }
}
