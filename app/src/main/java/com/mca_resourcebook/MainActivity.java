package com.mca_resourcebook;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener,View.OnClickListener {
//    public FirebaseAuth Auth;
//    public FirebaseUser currentUser;
    Button profile_button;
    TextView name;
    Button DateButton;
    Button TimeButton;
    Button CheckButton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ChangePasswordButton = findViewById(R.id.ChangePasswordButton);
//        sign_out_button = findViewById(R.id.sign_out_button);
        profile_button = findViewById(R.id.profile_button);
        name=findViewById(R.id.name);

        spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Spinner_item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        DateButton=findViewById(R.id.DateButton);
        DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker =new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");
            }
        });

        TimeButton=findViewById(R.id.TimeButton);
        TimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment TimePick=new TimePickerFragment();
                TimePick.show(getSupportFragmentManager(),"Time Picker");

            }

        });

        CheckButton=findViewById(R.id.CheckButton);
        CheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,BookingPage.class);
                startActivity(intent);
                MainActivity.this.finish();

            }
        });

        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileactivity = new Intent(MainActivity.this, profile.class);
                startActivity(profileactivity);
                MainActivity.this.finish();
            }
        });


//        Auth = FirebaseAuth.getInstance();
//        currentUser = Auth.getCurrentUser();
//        if (Auth.getCurrentUser() != null) {
//            name.setText(currentUser.getDisplayName());
//        }
//        ChangePasswordButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent forgotPasswordActivity = new Intent(MainActivity.this, ForgotPasswordActivity.class);
//                startActivity(forgotPasswordActivity);
//                MainActivity.this.finish();
//
//            }
//        });

//        sign_out_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Auth.signOut();
//                Intent logout = new Intent(MainActivity.this, SignInActivity.class);
//                startActivity(logout);
//                MainActivity.this.finish();
//                finish();
//            }
//        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}