package com.example.fitrecipe.Authen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fitrecipe.Adapter.AuthPagerAdapter;
import com.example.fitrecipe.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Activity_auth extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private AuthPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new AuthPagerAdapter(this);  // Đổi thành AuthPagerAdapter
        viewPager.setAdapter(adapter);

        // Đồng bộ TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Login");
                    } else {
                        tab.setText("Sign Up");
                    }
                }).attach();
    }
}