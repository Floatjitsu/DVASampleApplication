package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView mHobbies;
    private TextView mUserName, mUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = findViewById(R.id.text_user_name);
        mUserEmail = findViewById(R.id.text_user_email);
        mHobbies = findViewById(R.id.list_hobbies);
        //mUserHobbies = findViewById(R.id.text_user_hobbies);

        setObserver();
    }

    private void setObserver() {
        ViewModelUser viewModelUser = ViewModelProviders.of(this).get(ViewModelUser.class);
        LiveData<DataSnapshot> liveData = viewModelUser.getDataSnapshotLiveData();

        liveData.observe(this, new Observer<DataSnapshot>() {
            @Override
            public void onChanged(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if(user != null) {
                    mUserEmail.setText(user.getEmail());
                    mUserName.setText(user.getName());
                    mHobbies.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.hobby_list_item, user.getHobbies()));
                }
            }
        });
    }
}
