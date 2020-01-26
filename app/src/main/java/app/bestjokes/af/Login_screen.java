package app.bestjokes.af;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_screen extends AppCompatActivity {

     FirebaseAuth fireauthentication;
    EditText etemail,etpassword;
    Button btnlogn;

    TextView Tvnoacc,loginasguest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        fireauthentication = FirebaseAuth.getInstance();
        Tvnoacc = findViewById(R.id.Tvnoaccount);
        loginasguest = findViewById(R.id.Tvloginguest);

        etemail = findViewById(R.id.Etemail);
        etpassword = findViewById(R.id.Etpassword);
        btnlogn = findViewById(R.id.Btnlogin);
        Tvnoacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login_screen.this,Signup_screen.class);
                startActivity(intent);
            }
        });

        loginasguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_screen.this,Rec_view.class);
                startActivity(intent);
            }
        });

        btnlogn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();
                fireauthentication.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Intent intent = new Intent(Login_screen.this,Rec_view.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(Login_screen.this, "please make your email,password and internet connection", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });






    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser myuser = fireauthentication.getCurrentUser();

        if (myuser!=null) {

            Intent intent = new Intent(Login_screen.this,Rec_view.class);
            startActivity(intent);
            finish();
        }

    }
}
