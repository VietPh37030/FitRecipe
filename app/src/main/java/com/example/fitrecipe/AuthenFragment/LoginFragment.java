package com.example.fitrecipe.AuthenFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitrecipe.R;


public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout và gán vào biến rootView
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        // Tìm TextView bằng rootView
        TextView tvTerms = rootView.findViewById(R.id.tv_terms);

        // Set HTML text với màu và gạch chân
        tvTerms.setText(Html.fromHtml(getString(R.string.terms_text)));

        return rootView;
    }

}