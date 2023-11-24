package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity extends AppCompatActivity {

    private ListView notificationListView;
    private NotificationAdapter adapter;
    private List<NotificationItem> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        notificationListView = findViewById(R.id.notificationListView);

        // 임의의 데이터 생성
        notifications = new ArrayList<>();
        notifications.add(new NotificationItem("연결자 : 홍길동", "세븐일레븐 역삼8호점 앞 지남."));
        notifications.add(new NotificationItem("연결자 : 홍길동", "강남역 12번출구 지남."));
        // ... 추가 알림 데이터 ...

        // Custom Adapter에 데이터 연결
        adapter = new NotificationAdapter(this, notifications);

        // ListView에 Custom Adapter 설정
        notificationListView.setAdapter(adapter);
    }
}
