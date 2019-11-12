package com.example.sampleapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewModelUser extends ViewModel {

    private static final DatabaseReference USER_REF =
            FirebaseDatabase.getInstance().getReference("user");

    private final FirebaseQueryLiveData liveData = new FirebaseQueryLiveData(USER_REF);

    LiveData<DataSnapshot> getDataSnapshotLiveData() {
        return liveData;
    }
}
