package com.tiet.surveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.tiet.surveyapp.WeeklySurveyForm.CommonGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView gotoRegister,pwdReset;
    public EditText emailET, passwordET;
    public Button login,pwdResetBtn;
    ImageView googleRegister;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    int RC_SIGN_IN=200;
    int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        pwdReset=findViewById(R.id.forgotPassword);
        gotoRegister = (TextView) findViewById(R.id.gotoRegister);
        gotoRegister.setOnClickListener(this);
        emailET = findViewById(R.id.inputEmail);
        googleRegister = findViewById(R.id.googleLogin);
        passwordET = findViewById(R.id.inputPassword);
        login = findViewById(R.id.btnLogin);
        pwdResetBtn = findViewById(R.id.btnLogin2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emailET.getText().toString().isEmpty())
                    loginFirebase();
            }
        });
        pwdReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordET.setVisibility(View.GONE);
                pwdResetBtn.setVisibility(View.VISIBLE);
                emailET.setError("Enter your mail here to get a password reset mail");
                login.setVisibility(View.GONE);
                googleRegister.setVisibility(View.GONE);

                pwdResetBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(counter==0) {
                            mAuth.sendPasswordResetEmail(emailET.getText().toString());
                            pwdReset.setVisibility(View.GONE);
                            pwdResetBtn.setText("Login Again");
                            counter++;
                        }else{
                            startActivity(new Intent(LoginActivity.this,SplashScreen.class));
                        }

                    }
                });


            }
        });
        googleRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions
                        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();
                mGoogleSignInClient = GoogleSignIn.getClient(LoginActivity.this, gso);
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TEST", "signInWithCredential:success");
                            Toasty.success(LoginActivity.this, "Authentication Successful!", Toast.LENGTH_SHORT, true).show();

                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toasty.error(LoginActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT, true).show();

                            Log.w("TEST", "signInWithCredential:failure", task.getException());
//                            Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        Intent i = new Intent(LoginActivity.this,MainActivity.class);
//        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.gotoRegister:
                startActivity(new Intent(this, RegisterUser.class));
                break;


        }
    }

    public void loginFirebase(){
        mAuth.signInWithEmailAndPassword(emailET.getText().toString(), passwordET.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TEST", "signInWithEmail:success");  Toasty.success(LoginActivity.this, "Authentication Successful!", Toast.LENGTH_SHORT, true).show();

                            FirebaseUser user = mAuth.getCurrentUser();
                            WeekSurveyData.setUserID(mAuth.getUid());
                            Intent i = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TEST", "signInWithEmail:failure", task.getException());
                            Toasty.error(LoginActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT, true).show();


                        }

                        // ...
                    }
                });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("TEST", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TEST", "Google sign in failed", e);
            }
        }
    }
}