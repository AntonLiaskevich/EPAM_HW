package com.example.user.epam_hw;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class ProfileView extends RelativeLayout {

    private ImageView profileImage;

    public ProfileView(Context context) {
        super(context);
        init();
    }

    public ProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_profile, this);
        setGravity(Gravity.BOTTOM);
        profileImage = findViewById(R.id.face_image);
        profileImage.setOnClickListener(listener);
    }

    OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Random rand = new Random();
            profileImage.setColorFilter(Color.rgb(rand.nextInt(254) + 1, rand.nextInt(254) + 1, rand.nextInt(254) + 1));
        }
    };
}

