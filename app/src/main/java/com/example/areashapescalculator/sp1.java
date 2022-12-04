package com.example.areashapescalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class sp1 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp1);

        Bundle extras = getIntent().getExtras();
        String result = extras.getString("result");
        setContentView(R.layout.sp1);

        Button btnReturn = findViewById(R.id.btn_return);
        TextView tvResult = findViewById(R.id.txt_result);
        tvResult.setText(result);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(sp1.this, Main_Activity.class);
        startActivity(intent);
    }
}