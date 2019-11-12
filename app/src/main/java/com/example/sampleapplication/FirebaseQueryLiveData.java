package com.example.sampleapplication;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FirebaseQueryLiveData extends LiveData<DataSnapshot> {

    private final Query query;
    private final MyValueEventListener listener = new MyValueEventListener();

    FirebaseQueryLiveData(DatabaseReference ref) {
        this.query = ref;
    }

    @Override
    protected void onActive() {
        query.addValueEventListener(listener);
        super.onActive();
    }

    @Override
    protected void onInactive() {
        query.removeEventListener(listener);
        super.onInactive();
    }

    private class MyValueEventListener implements ValueEventListener {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            setValue(dataSnapshot);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }
}
