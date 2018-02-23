package com.example.trnclong.intent_ptbacnhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    EditText edtKetQua;
    Button btnBack;
    Intent callerIntent;
    Bundle packBundle;
    DecimalFormat decimalFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getData();
        addControls();
        addEvents();
    }
    private void addControls() {
        edtKetQua = findViewById(R.id.ketQua);
        btnBack = findViewById(R.id.btnBack);
    }

    private void addEvents() {
        giaiPTBN();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = packBundle.getFloat("heSoA");
                float b= packBundle.getFloat("heSoB");
                Toast.makeText(ResultActivity.this,"Wellcome back to MainActivity! Chỉnh sửa lần cuối của bạn: a ="+a+", b = "+b+"",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    public void getData() {
         callerIntent = getIntent();
        packBundle = callerIntent.getBundleExtra("data");

    }

    public void giaiPTBN() {
        float a = packBundle.getFloat("heSoA");
        float b= packBundle.getFloat("heSoB");
        if(b==0) {
            edtKetQua.setText("Phuong Trinh Vo So Nghiem");
        }
        else {
            float c=0;
            c = -b/a;
            decimalFormat = new DecimalFormat("#.###");
            edtKetQua.setText(String.valueOf( decimalFormat.format(c) ));
        }

    }
}
