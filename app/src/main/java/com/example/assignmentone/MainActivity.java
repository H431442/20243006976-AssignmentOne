package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire up the four image buttons. The same IDs are used in both the
        // portrait and landscape layouts, so this works for either orientation.
        ImageButton facilitiesButton = findViewById(R.id.btnFacilities);
        ImageButton eventsButton = findViewById(R.id.btnEvents);
        ImageButton clubsButton = findViewById(R.id.btnClubs);
        ImageButton supportButton = findViewById(R.id.btnSupport);

        facilitiesButton.setOnClickListener(v ->
                showToast(getString(R.string.facilities) + " clicked"));
        eventsButton.setOnClickListener(v ->
                showToast(getString(R.string.events) + " clicked"));
        clubsButton.setOnClickListener(v ->
                showToast(getString(R.string.clubs) + " clicked"));
        supportButton.setOnClickListener(v ->
                showToast(getString(R.string.support) + " clicked"));
    }

    /** Display a short Toast message to confirm a button was clicked. */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
