package com.example.mydoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class contaactus2 extends AppCompatActivity {

    EditText emailEdit;
    EditText subjectEdit;
    EditText messageEdit;

    public static final String EMAIL = "maleknp127@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contaactus2);
        emailEdit = findViewById(R.id.email);
        subjectEdit = findViewById(R.id.subject);
        messageEdit = findViewById(R.id.message);

        Button buttonsend = findViewById(R.id.send);
        buttonsend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sendMail();
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


    public void sendMail(){
        String emailString = emailEdit.getText().toString();
        String subjectString = subjectEdit.getText().toString();
        String messageString = messageEdit.getText().toString();
        if(emailString.isEmpty() || subjectString.isEmpty() || messageString.isEmpty()){
            Toast.makeText(this, "Filed is requried",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{EMAIL});
        intent.putExtra(Intent.EXTRA_SUBJECT,subjectString);
        intent.putExtra(Intent.EXTRA_TEXT,messageString);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "cchoose an email client"));

    }



}
