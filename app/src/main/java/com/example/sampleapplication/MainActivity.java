package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");

    private TextView mUserName, mUserEmail, mUserHobbies;
    private TextView mTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = findViewById(R.id.text_user_name);
        mUserEmail = findViewById(R.id.text_user_email);
        mUserHobbies = findViewById(R.id.text_user_hobbies);

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
                    mUserHobbies.setText(user.getHobbies());
                }
            }
        });
    }
}
