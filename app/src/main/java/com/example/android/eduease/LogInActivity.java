package com.example.android.eduease;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    Button regis;
    private FirebaseAuth mAuth;
    EditText emailText,passwordText;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        regis = findViewById(R.id.button);
        regis.setText("LOGIN");
        mAuth = FirebaseAuth.getInstance();


        regis.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {

                                         emailText = findViewById(R.id.editText);
                                         email = emailText.getText().toString().trim();

                                         passwordText = findViewById(R.id.editText2);
                                         password = passwordText.getText().toString().trim();

                                         (mAuth.signInWithEmailAndPassword(email,password))
                                                 .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                     @Override
                                                     public void onComplete(@NonNull Task<AuthResult> task) {
                                                         if (task.isSuccessful()) {
                                                             Toast.makeText(getApplicationContext(), "SUCCESSFULLY LOGGED IN", Toast.LENGTH_SHORT).show();

                                                             Intent i= new Intent (getApplicationContext(),newactivity.class);
                                                             startActivity(i);
                                                         }
                                                         else
                                                             Toast.makeText(getApplicationContext(), " NOT LOGGED IN", Toast.LENGTH_SHORT).show();

                                                     }
                                                 });
                                     }
                                 }
        );
    }
}