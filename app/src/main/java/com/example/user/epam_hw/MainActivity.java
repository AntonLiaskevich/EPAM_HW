package com.example.user.epam_hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "first feature2", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "second feature2", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "first feature1", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "second feature1", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "third feature1", Toast.LENGTH_LONG).show();


        Toast.makeText(getApplicationContext(), "third feature2", Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(), "using stash", Toast.LENGTH_LONG).show();
    }
}
