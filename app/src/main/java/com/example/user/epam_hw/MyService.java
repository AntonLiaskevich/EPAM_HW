package com.example.user.epam_hw;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Color;

import java.util.Random;

public class MyService extends IntentService {

    public static final String COLORS_OF_BACKGROUND = "Colors";
    public static final String START_SERVICE = "StartService";
    public static final String ACTION_CHANGE_COLOR = "ChangeColor";
    public static final String MY_SERVICE = "MyService";
    public static final boolean CHANGE_COLORS = true;
    private Intent responseIntent;

    Random rand = new Random();

    public MyService() {
        super(MY_SERVICE);
    }

    public void onCreate() {
        super.onCreate();

        responseIntent = new Intent();
        responseIntent.setAction(ACTION_CHANGE_COLOR);
        responseIntent.addCategory(Intent.CATEGORY_DEFAULT);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            while (CHANGE_COLORS) {
                int r = rand.nextInt(254) + 1;
                int g = rand.nextInt(254) + 1;
                int b = rand.nextInt(254) + 1;
                int randomColor = Color.rgb(r, g, b);
                responseIntent.putExtra(COLORS_OF_BACKGROUND, randomColor);
                sendBroadcast(responseIntent);
                Thread.sleep(500); }
        } catch (InterruptedException e) {
        }
    }
}


