package com.tiet.surveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;

import es.dmoral.toasty.Toasty;

public class RegisterUser extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView gotoLogin;
    EditText email,password,confirmpwd;

    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        email = findViewById(R.id.inputNewEmail);
        password = findViewById(R.id.inputNewPassword);
        confirmpwd = findViewById(R.id.ConfirmPassword);
        register = findViewById(R.id.btnRegister);
        gotoLogin=findViewById(R.id.gotoLogin);

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterUser.this,LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });



    }
    public void signUp(){
        if(password.getText().toString().equals(confirmpwd.getText().toString())){
            mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TEST", "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                WeekSurveyData.setUserID(user.getUid());
                                Toasty.success(RegisterUser.this, "Authentication Successful!", Toast.LENGTH_SHORT, true).show();

                                Intent i = new Intent(RegisterUser.this,MainActivity.class);
                                startActivity(i);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TEST", "createUserWithEmail:failure", task.getException());
                                Toasty.error(RegisterUser.this, "Authentication Failed!", Toast.LENGTH_SHORT, true).show();

                                // updateUI(null);
                            }

                            // ...
                        }
                    });
        }else{
            confirmpwd.setError("PWD doesn't match !");
        }
    }
}