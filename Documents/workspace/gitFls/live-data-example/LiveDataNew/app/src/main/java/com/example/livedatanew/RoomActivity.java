package com.example.livedatanew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//import com.example.livedatanew.database.AppDatabase;
//import com.example.livedatanew.database.Message;
//import com.example.livedatanew.database.MessageDao;

import com.example.livedatanew.Services.TestService;
import com.example.livedatanew.database.AppDatabase;
import com.example.livedatanew.database.Message;
import com.example.livedatanew.database.MessageDao;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RoomActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        MessageDao messageDao = (MessageDao) AppDatabase.getInstance(getApplicationContext()).message();
        messageDao.getAllMessage().observe(this,
                (List<Message> message)->{
                    roomAdapter = new RoomAdapter(message, RoomActivity.this);
                    recyclerView.setAdapter(roomAdapter);
                });
        ImageView addMessageBtn = (ImageView) findViewById(R.id.add_btn);
        addMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageDialog dialog = new MessageDialog(RoomActivity.this);
                dialog.addNewMessage(R.layout.dialog_layout);
            }
        });
        Intent intent = new Intent(RoomActivity.this, TestService.class);
        Button startActivity = (Button)findViewById(R.id.startService);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
    }
}
