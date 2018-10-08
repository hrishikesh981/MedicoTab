package com.example.grajmane.medico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Register extends AppCompatActivity {


    private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFirebaseAuth=FirebaseAuth.getInstance();


        //init_main();


    }
    protected void onStart() {
        super.onStart();
        FirebaseUser currFirebaseUser=mFirebaseAuth.getCurrentUser();
        if (currFirebaseUser != null) {
            gotoHome(currFirebaseUser);
        }
    }

    public void register(View view) {
        EditText euname=findViewById(R.id.email_register);
        EditText epwd=findViewById(R.id.passwords_register);
        EditText epwd2=findViewById(R.id.password_2_register);
        //final TextView tset=findViewById(R.id.textView4);
        if(epwd.getText().toString().equals(epwd2.getText().toString()))
        {
            mFirebaseAuth.createUserWithEmailAndPassword(euname.getText().toString(),epwd.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("", "createUserWihEmail:Successful");
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                if (user != null) {
                                    gotoHome(user);
                                }
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Register.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                // tset.setText(task.getException().toString());
                            }
                        }
                    });
        }


    }



    public void gotoLogin(View view) {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);


    }private void gotoHome( FirebaseUser currFirebaseUser) {

        Intent intent=new Intent(this,Main2Activity.class);
//        TextView tset1=findViewById(R.id.navbar_email);
//        tset1.setText(currFirebaseUser.getEmail());
        startActivity(intent);
    }

}
