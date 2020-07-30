package com.mca_resourcebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profile extends AppCompatActivity implements View.OnClickListener{
    public FirebaseAuth Auth;
    public FirebaseUser currentUser;
    FirebaseDatabase RootNode;
    DatabaseReference reference;
    Button ChangePasswordButton;
    Button sign_out_button;
    TextView name;
    Button SaveButton;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ChangePasswordButton = findViewById(R.id.ChangePasswordButton);
        sign_out_button = findViewById(R.id.sign_out_button);
        name=findViewById(R.id.name);
        SaveButton = findViewById(R.id.SaveButton);
        back = findViewById(R.id.back);


        Auth = FirebaseAuth.getInstance();
        currentUser = Auth.getCurrentUser();

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                RootNode= FirebaseDatabase.getInstance();
//                reference= RootNode.getReference("mca-resourcebook");
//                reference.child(String.valueOf(name)).setValue(name);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent backhome = new Intent(profile.this, MainActivity.class);
                startActivity(backhome);
                profile.this.finish();

            }
        });

        ChangePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotPasswordActivity = new Intent(profile.this, ForgotPasswordActivity.class);
                startActivity(forgotPasswordActivity);
                profile.this.finish();

            }
        });

        sign_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Auth.signOut();
                Intent logout = new Intent(profile.this, SignInActivity.class);
                startActivity(logout);
                profile.this.finish();
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
