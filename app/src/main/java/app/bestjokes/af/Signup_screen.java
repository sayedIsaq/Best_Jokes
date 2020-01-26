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

public class Signup_screen extends AppCompatActivity {

    EditText etemail,etpassword,etconfirmpassword;
    Button btnsignup;
    TextView tvnoaccount;
    FirebaseAuth myauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        tvnoaccount = findViewById(R.id.Tvnoaccount);
        tvnoaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup_screen.this,Login_screen.class);
                startActivity(intent);
            }
        });
        etemail = findViewById(R.id.Etsignupemail);
        etpassword = findViewById(R.id.Etsignuppassword);
        etconfirmpassword = findViewById(R.id.Etsignupconfirmpassword);
        btnsignup = findViewById(R.id.btnsignup);

        myauth = FirebaseAuth.getInstance();

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etemail.getText().toString();
                String Password = etpassword.getText().toString();
                String repassword = etconfirmpassword.getText().toString();

                    myauth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(Signup_screen.this,Rec_view.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(Signup_screen.this, "Please make sure your email and password are in correct farmat", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            }
        });


    }
}


