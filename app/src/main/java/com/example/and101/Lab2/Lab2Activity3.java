package com.example.and101.Lab2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.and101.R;

public class Lab2Activity3 extends AppCompatActivity {
    TextView txtResult;
    EditText edtName, edtId, edtAge;
    RadioButton rdoMale, rdoFemale;
    CheckBox chkFootball, chkPlayGame;
    Button btnSubmit;
    ImageView anh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity3_lab2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setEditTextFocusListeners();
        anh = findViewById(R.id.anh);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Submit();
            }
        });
    }

    private void Submit(){
        String name = edtName.getText().toString();
        String id = edtId.getText().toString();
        String age = edtAge.getText().toString();
        String gender = rdoFemale.isChecked() ? rdoFemale.getText().toString() : rdoMale.isChecked() ? rdoMale.getText().toString() : "Chưa lựa chọn giới tính";
        String interest = chkFootball.isChecked() && chkPlayGame.isChecked() ? "Đá bóng và chơi game" : chkFootball.isChecked() ? chkFootball.getText().toString() : chkPlayGame.isChecked() ? chkPlayGame.getText().toString() : "Không thích gì cả";
        txtResult.setText("Tôi tên: " + name + "\n" + "MSSV: " + id + "\n" + "Tuổi: " + age + "\n" + "Giới tính: " + gender + "\n" + "Sở thích: " + interest);
    }

    private void init() {
        txtResult = findViewById(R.id.txtResult);
        edtName = findViewById(R.id.edtName);
        edtId = findViewById(R.id.edtId);
        edtAge = findViewById(R.id.edtAge);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        chkFootball = findViewById(R.id.chkFootball);
        chkPlayGame = findViewById(R.id.chkPlayGame);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
    private void setEditTextFocusListeners() {
        View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    anh.setVisibility(View.GONE);
                } else if (!edtName.hasFocus() && !edtId.hasFocus() && !edtAge.hasFocus()) {
                    anh.setVisibility(View.VISIBLE);
                }
            }
        };

        edtName.setOnFocusChangeListener(focusChangeListener);
        edtId.setOnFocusChangeListener(focusChangeListener);
        edtAge.setOnFocusChangeListener(focusChangeListener);
    }
}