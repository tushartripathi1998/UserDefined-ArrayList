package com.example.roomlibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    public EditText userId, userName, userEmail;
    private Button bnSave;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        userId = view.findViewById(R.id.user_id);
        userName = view.findViewById(R.id.name);
        userEmail = view.findViewById(R.id.email);

        bnSave = view.findViewById(R.id.save);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid = Integer.parseInt(userId.getText().toString());
                String username = userName.getText().toString();
                String useremail = userEmail.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDoa().addUser(user);
            }
        });

        return view;
    }

}
