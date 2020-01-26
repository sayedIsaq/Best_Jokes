package app.bestjokes.af;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splah_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent =  new Intent(Splah_screen.this,Login_screen.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
