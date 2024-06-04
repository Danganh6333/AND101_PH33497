package com.example.and101.Lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.and101.R;

public class Lab4Activity3 extends AppCompatActivity {
    TextView txtPrice;
    EditText edtName;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity3_lab4);
        txtPrice = findViewById(R.id.txtPrice);
        edtName = findViewById(R.id.edtName);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab4Activity3.this, Lab4Activity4.class);
                intent.putExtra("name",edtName.getText().toString());
                getQuote.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> getQuote = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if (o.getResultCode() == 1) {
                        Intent intent = o.getData();
                        if (intent != null) {
                            Bundle bundle = intent.getExtras();
                            String priceQuote = bundle.getString("priceQuote");
                            txtPrice.setText(priceQuote);
                        }
                    }
                }
            }
    );
}