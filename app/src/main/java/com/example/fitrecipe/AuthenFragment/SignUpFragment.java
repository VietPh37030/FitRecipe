package com.example.fitrecipe.AuthenFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fitrecipe.R;

public class SignUpFragment extends Fragment {

    private EditText nameEditText, emailEditText, passEditText, confirmPassEditText;
    private TextView errorEmail, errorConfirmPassword, errorFullName;
    private ImageView imgCheckLength, imgCheckNumber, imgCheckUppercase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // Ánh xạ View
        nameEditText = view.findViewById(R.id.namelEditTextSignup);
        emailEditText = view.findViewById(R.id.emailEditTextSignup);
        passEditText = view.findViewById(R.id.passEditTextSignup);
        confirmPassEditText = view.findViewById(R.id.confimpassEditTextSignup);

        errorEmail = view.findViewById(R.id.errorEmail);
        errorConfirmPassword = view.findViewById(R.id.errorConfirmPassword);
        errorFullName = view.findViewById(R.id.errorFullName);

        imgCheckLength = view.findViewById(R.id.imgcheckkitu);
        imgCheckNumber = view.findViewById(R.id.imgcheckso);
        imgCheckUppercase = view.findViewById(R.id.imgcheckinhoa);

        // Thêm sự kiện lắng nghe
        addTextWatchers();

        return view;
    }

    private void addTextWatchers() {
        // Kiểm tra họ tên không có ký tự đặc biệt
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    errorFullName.setVisibility(View.GONE); // Ẩn lỗi nếu trường trống
                } else if (charSequence.toString().matches(".*[@#!$%^&*()_+=|<>?{}\\[\\]~-].*")) {
                    errorFullName.setVisibility(View.VISIBLE);
                } else {
                    errorFullName.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Kiểm tra định dạng email
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    errorEmail.setVisibility(View.GONE); // Ẩn lỗi nếu trường trống
                } else if (!Patterns.EMAIL_ADDRESS.matcher(charSequence).matches()) {
                    errorEmail.setVisibility(View.VISIBLE);
                } else {
                    errorEmail.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Kiểm tra mật khẩu (độ dài, số, chữ in hoa)
        passEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = charSequence.toString();

                if (password.isEmpty()) {
                    imgCheckLength.setImageResource(R.drawable.nopassone);
                    imgCheckNumber.setImageResource(R.drawable.nopassone);
                    imgCheckUppercase.setImageResource(R.drawable.nopassone);
                } else {
                    imgCheckLength.setImageResource(password.length() >= 8 ? R.drawable.pass : R.drawable.nopassone);
                    imgCheckNumber.setImageResource(password.matches(".*\\d.*") ? R.drawable.pass : R.drawable.nopassone);
                    imgCheckUppercase.setImageResource(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") ? R.drawable.pass : R.drawable.nopassone);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Kiểm tra xác nhận mật khẩu
        confirmPassEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    errorConfirmPassword.setVisibility(View.GONE); // Ẩn lỗi nếu trường trống
                } else if (!charSequence.toString().equals(passEditText.getText().toString())) {
                    errorConfirmPassword.setVisibility(View.VISIBLE);
                } else {
                    errorConfirmPassword.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}
