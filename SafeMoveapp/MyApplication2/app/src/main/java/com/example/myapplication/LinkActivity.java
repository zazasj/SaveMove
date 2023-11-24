package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LinkActivity extends AppCompatActivity {

    private EditText editCode;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        editCode = findViewById(R.id.editCode);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editCode.getText().toString();
                if (!code.isEmpty()) {
                    //Intent intent = new Intent(LinkActivity.this, A.class);
                    //intent.putExtra("code", code);
                    //startActivity(intent);
                } else {
                    Toast.makeText(LinkActivity.this, "코드를 등록했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}