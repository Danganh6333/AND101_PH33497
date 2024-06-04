package com.example.and101.Lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.and101.R;

public class Lab4Activity4 extends AppCompatActivity {
    EditText edtPrice;
    Button btnQuote;
    TextView txtItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity4_lab4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtPrice = findViewById(R.id.edtPrice);
        btnQuote = findViewById(R.id.btnQuote);
        txtItem = findViewById(R.id.txtItem);
        Intent intent = getIntent();
        String price = intent.getStringExtra("name");
        txtItem.setText(price);
        btnQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quote();
            }
        });
    }

    private void Quote(){
        String priceQuote = edtPrice.getText().toString();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("priceQuote",priceQuote);
        intent.putExtras(bundle);
        setResult(1,intent);
        finish();
    }
}