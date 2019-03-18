package com.example.user.epam_hw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

class MyBroadcastReceiver extends BroadcastReceiver {
    TextView textView;

    MyBroadcastReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int currentColor = intent.getIntExtra(MyService.COLORS_OF_BACKGROUND,0);
        textView.setBackgroundColor(currentColor);
    }
}
