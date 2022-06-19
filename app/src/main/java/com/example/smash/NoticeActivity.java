package com.example.smash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class NoticeActivity extends AppCompatActivity {

    ListView listView;
    NoticeListAdapter noticeListAdapter;
    ArrayList<GetSetNotice> list_itemArrayList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Button noticeBack = (Button) findViewById(R.id.noticeBack);
        Button noticeOnOff = (Button) findViewById(R.id.noticeOnOff);

        noticeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RealMainActivity.class);
                startActivity(intent);
            }
        });
        noticeOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice);
        listView = (ListView) findViewById(R.id.listView);
        Button roomInfo = (Button) findViewById(R.id.RoomInfo);
        Button scheBtn = (Button) findViewById(R.id.ScheduleBtn);
        Button noticeBtn = (Button) findViewById(R.id.noticeBtn);

        list_itemArrayList = new ArrayList<GetSetNotice>();

        list_itemArrayList.add(
                new GetSetNotice(R.mipmap.ic_launcher,"최지원", "모바일프로그래밍 스터디",
                new Date(System.currentTimeMillis()), "모프 과제 같이해요"));
        list_itemArrayList.add(
                new GetSetNotice(R.mipmap.ic_launcher,"박태연", "컴퓨터알고리즘",
                        new Date(System.currentTimeMillis()), "컴알 팀플방"));
        list_itemArrayList.add(
                new GetSetNotice(R.mipmap.ic_launcher,"하재민", "자바웹애플리케이션",
                        new Date(System.currentTimeMillis()), "서버 같이 만들어요"));
        list_itemArrayList.add(
                new GetSetNotice(R.mipmap.ic_launcher,"누구게", "모바일프로그래밍 스터디",
                        new Date(System.currentTimeMillis()), "DB 어떻게해요"));

        noticeListAdapter = new NoticeListAdapter(NoticeActivity.this, list_itemArrayList);
        listView.setAdapter(noticeListAdapter);

        roomInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
                startActivity(intent);
            }
        });
        scheBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
                startActivity(intent);
            }
        });
    }
}
