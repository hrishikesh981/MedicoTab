package com.example.grajmane.medico;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {


    private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth=FirebaseAuth.getInstance();

    }

    public void gotoRegistration(View view) {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currFirebaseUser = mFirebaseAuth.getCurrentUser();
        //TextView tset=findViewById(R.id.textView3);
        if (currFirebaseUser != null) {
            //tset.setText(currFirebaseUser.getEmail());
            gotoHome(currFirebaseUser);
        }
    }

    private void gotoHome( FirebaseUser currFirebaseUser) {

        Intent intent=new Intent(this,Main2Activity.class);
//        TextView tset1=findViewById(R.id.navbar_email);
//        tset1.setText(currFirebaseUser.getEmail());
        startActivity(intent);
    }

    public void login(View view) {
        EditText euname= findViewById(R.id.email_login);
        EditText epwd= findViewById(R.id.pass_login);
        //final TextView tset=findViewById(R.id.textView3);
        mFirebaseAuth.signInWithEmailAndPassword(euname.getText().toString(),epwd.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "signInWithEmail:success");
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            if (user != null) {
                                gotoHome(user);
                            }
                        }else{
                            // If sign in fails, display a message to the user.
                            Log.d("", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //tset.setText(Objects.requireNonNull(task.getException()).toString());
                        }
                    }
                });
    }


}



