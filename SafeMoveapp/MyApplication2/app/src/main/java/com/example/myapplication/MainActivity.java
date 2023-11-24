package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout smbutton;
    private LinearLayout findRoadLayout;
    private LinearLayout noticelayout;
    private LinearLayout linklayout;

    private ImageView smbuttonimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findRoadLayout = findViewById(R.id.findroad);
        //LinearLayout EmNum = findViewById(R.id.emnum);
        smbutton = findViewById(R.id.smbutton);
        noticelayout = findViewById(R.id.notice);
        linklayout = findViewById(R.id.link);
        smbuttonimage = findViewById(R.id.smbuttonimage);



        findRoadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FindRoad.class);
                startActivity(intent);
            }
        });

        noticelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        linklayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinkActivity.class);
                startActivity(intent);
            }
        });

        smbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BubbleFragment fragment = (BubbleFragment) getSupportFragmentManager().findFragmentById(R.id.fragposition);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if (fragment != null && fragment.isVisible()) {
                    // Fragment가 이미 표시 중이면 제거
                    transaction.remove(fragment);
                    smbuttonimage.setImageResource(R.drawable.smbutton);
                } else {
                    // Fragment가 표시 중이지 않으면 추가
                    transaction.replace(R.id.fragposition, new BubbleFragment());
                    smbuttonimage.setImageResource(R.drawable.smbutton_green);
                }
                transaction.commit();
            }
        });

        final LinearLayout rootLayout = findViewById(R.id.root_layout); // 루트 레이아웃의 ID를 'root_layout'로 가정
        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    BubbleFragment fragment = (BubbleFragment) getSupportFragmentManager().findFragmentById(R.id.fragposition);
                    if (fragment != null && fragment.isVisible()) {
                        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        return true; // 터치 이벤트 소비
                    }
                }
                return false;
            }
        });





    }




}