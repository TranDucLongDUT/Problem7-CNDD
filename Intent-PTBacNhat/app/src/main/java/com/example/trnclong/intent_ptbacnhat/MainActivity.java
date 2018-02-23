package com.example.trnclong.intent_ptbacnhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtHeSoA, edtHeSoB;
    Button btnKetQua, btnReset, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        edtHeSoA = findViewById(R.id.heSoA);
        edtHeSoB = findViewById(R.id.heSoB);
        btnKetQua = findViewById(R.id.btnKetQua);
        btnReset = findViewById(R.id.btnReset);
        btnExit = findViewById(R.id.btnExit);
    }
    private void addEvents() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeSoA.setText("");
                edtHeSoB.setText("");
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String a = edtHeSoA.getText().toString();
                    String b = edtHeSoB.getText().toString();
                    float soA = Float.parseFloat(a);
                    float soB = Float.parseFloat(b);
                    if(soA==0) {
                        Toast.makeText(MainActivity.this,"Vui Long Nhap A khac 0", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Bundle bundle = new Bundle();
                        bundle.putFloat("heSoA",soA);
                        bundle.putFloat("heSoB",soB);
                        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                        intent.putExtra("data",bundle);
                        startActivity(intent);
                        edtHeSoA.setText("");
                        edtHeSoB.setText("");
                    }
                }
                catch (Exception e) {
                    Toast.makeText(MainActivity.this,"Vui Long Nhap So", Toast.LENGTH_LONG).show();
                }
            }
        });
    }




}
