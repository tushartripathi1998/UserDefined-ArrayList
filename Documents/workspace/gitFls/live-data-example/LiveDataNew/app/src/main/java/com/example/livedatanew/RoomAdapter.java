package com.example.livedatanew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livedatanew.database.AppDatabase;
import com.example.livedatanew.database.Message;
import com.example.livedatanew.database.MessageDao;

import java.util.Date;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private List<Message> messageList;
    private Context context;

    public RoomAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_layout,parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Message message = messageList.get(position);
        String currentDate = "test";//getCurrentDate();
        holder.content.setText(message.getContent());
        holder.date.setText(currentDate);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, message.getContent(), Toast.LENGTH_LONG).show();
                MessageDao messageDao = (MessageDao) AppDatabase.getInstance(context).message();
                messageDao.deleteMessage(message);
//                messageList.remove(position);
                //for deletion
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

//    public String getCurrentDate()
//    {
//        Date currentDate = new Date();
//        DateTime dt =
//    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        public TextView content;
        public TextView date;
        public ImageView delete;

        public RoomViewHolder(View view) {
            super(view);
            content = view.findViewById(R.id.content);
            date = view.findViewById(R.id.date);
            delete = view.findViewById(R.id.delete);
        }
    }
}
