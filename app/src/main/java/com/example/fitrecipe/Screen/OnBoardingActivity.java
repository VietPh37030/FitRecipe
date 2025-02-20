package com.example.fitrecipe.Screen;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.fitrecipe.R;

public class OnBoardingActivity extends AppCompatActivity {
ViewPager viewPager;
LinearLayout dotlaayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
    }
}