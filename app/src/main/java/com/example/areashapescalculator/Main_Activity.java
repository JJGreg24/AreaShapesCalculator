package com.example.areashapescalculator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText speed;
    String  strspeed, resultMessage;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(this);

    }

    public void onClick(View v){
        Toast.makeText(this, "Checking Speed Limit...", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        speed = (EditText) findViewById(R.id.limit);
        if(speed.getText().toString().isEmpty()){
            strspeed = "0";
        }
        else{
            strspeed = speed.getText().toString();
        }
        double rawspeed = Double.parseDouble(strspeed);

        double result = rawspeed;

        switch((int) result){
            case 70:
                result = 70;
                break;
            case 90:
                result = 90;
                break;
            case 150:
                result = 150;
                break;
        }



        resultMessage = (int) result + " " + "is your speed limit";

        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        Intent intent;


        if(result <= 70) {
            intent = new Intent(Main_Activity.this, sp1.class);
        }
        else if (result <= 90) {
            intent = new Intent(Main_Activity.this, sp2.class);
        }
        else {
            intent = new Intent(Main_Activity.this, sp3.class);
        }


        intent.putExtras(args);
        startActivity(intent);
        clearEditText();
    }

    public void clearEditText(){
        speed.getText().clear();
        speed.requestFocus();
    }

}
