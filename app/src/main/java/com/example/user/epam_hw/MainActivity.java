package com.example.user.epam_hw;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String CURRENT_COLOR = "currentColor";
    private MyBroadcastReceiver myBroadcastReceiver;
    private TextView textView;
    private Button startServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseView();
        registerBroadcastReceiver();
    }

    private void registerBroadcastReceiver() {
        myBroadcastReceiver = new MyBroadcastReceiver(textView);
        IntentFilter intentFilter = new IntentFilter(MyService.ACTION_CHANGE_COLOR);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    private void initialiseView() {
        textView = findViewById(R.id.counterTextView);
        startServiceButton = findViewById(R.id.startServiceButton);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(myBroadcastReceiver);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(CURRENT_COLOR, textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString(CURRENT_COLOR));
    }

    public void startService(View v) {
        Intent myService = new Intent(this, MyService.class);
        startService(myService.putExtra(MyService.START_SERVICE, true));
        startServiceButton.setEnabled(false);
    }
}