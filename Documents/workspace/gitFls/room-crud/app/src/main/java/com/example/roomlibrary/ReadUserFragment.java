package com.example.roomlibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView textView;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        textView = view.findViewById(R.id.text);

        List<User> users = MainActivity.myAppDatabase.myDoa().getUsers();

        String info = "";

        for(User usr : users)
        {
            int id = usr.getId();
            String name = usr.getName();
            String email = usr.getEmail();
            info = info+"\n\n"+"id : "+id+"\n Name: "+name+"\n "+"Email :"+email;
        }

        textView.setText(info);

        return view;
    }

}
