package com.example.mydoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.getbase.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class doctorsSlide extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    String URL = "http://192.168.1.170/my-doctor/public/api/departments/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_slide);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    ArrayList<Model> departmentArrayList = new ArrayList<>();
                    for (int i =0; i<response.length(); i++){
                        JSONObject object = response.getJSONObject(i);
                        int id = object.getInt("id");
                        String name = object.getString("department");
                        String image = object.getString("img");
                        Model data = new Model(name,image,id);
                        departmentArrayList.add(data);
                    }
                    viewPager = findViewById(R.id.viewPager);
                    adapter = new Adapter(departmentArrayList,getApplicationContext());
                    viewPager.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                Toast.makeText(doctorsSlide.this, "wrong data", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        requestQueue.add(arrayRequest);
        //  models = new ArrayList<>();
        //  models.add(new Model(R.drawable.brochure, "Brochure Dcotors", ""));
        //  models.add(new Model(R.drawable.sticker, "sticker Dcotors", ""));
        //  models.add(new Model(R.drawable.poster, "poster Dcotors", ""));
        //  models.add(new Model(R.drawable.namecard, "namecard Dcotors", ""));




        viewPager.setPadding(130,0,130,0);

        Button btnOrder = (Button) findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View){
                Intent myLink = new Intent(Intent.ACTION_VIEW);
                myLink.setData(Uri.parse("http://localhost/my-doctor/public/mydoctor"));
                startActivity(myLink);
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
