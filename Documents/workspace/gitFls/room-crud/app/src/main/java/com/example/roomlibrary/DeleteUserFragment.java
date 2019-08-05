package com.example.roomlibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {

    public Button delete_user_button;
    public TextView userId;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        userId = view.findViewById(R.id.user_id);
        delete_user_button = view.findViewById(R.id.deleteUser);

        delete_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(userId.getText().toString());
                User user = new User();
                user.setId(id);

                MainActivity.myAppDatabase.myDoa().deleteUser(user);
            }
        });

        return view;
    }

}
