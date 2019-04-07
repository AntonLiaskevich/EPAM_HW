package com.example.user.epam_hw;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Color;

import java.util.Random;

public class MyService extends IntentService {

    public static final String COLORS_OF_BACKGROUND = "Colors";
    public static final String START_SERVICE = "StartService";
    public static final String ACTION_CHANGE_COLOR = "ChangeColor";
    public static final boolean CHANGE_COLORS = true;
    private static final String MY_SERVICE = "MyService";

    private Intent responseIntent;

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
        Random rand = new Random();
        try {
            while (CHANGE_COLORS) {
                int randomColor = Color.rgb(rand.nextInt(254) + 1,
                        rand.nextInt(254) + 1, rand.nextInt(254) + 1);
                responseIntent.putExtra(COLORS_OF_BACKGROUND, randomColor);
                sendBroadcast(responseIntent);
                Thread.sleep(500); }
        }
        catch (InterruptedException ignored) {
        }
    }
}


