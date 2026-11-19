package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        facilitiesButton.setOnClickListener(v -> onSectionClicked(0));
        eventsButton.setOnClickListener(v -> onSectionClicked(1));
        clubsButton.setOnClickListener(v -> onSectionClicked(2));
        supportButton.setOnClickListener(v -> onSectionClicked(3));
    }

    /**
     * Handle a section button click: show feedback, then start DetailActivity
     * with an Intent carrying which section was selected.
     */
    private void onSectionClicked(int sectionIndex) {
        String[] labels = getResources().getStringArray(R.array.string_array_titles);
        showToast(labels[sectionIndex] + " clicked");

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(getString(R.string.extra_section_index), sectionIndex);
        startActivity(intent);
    }

    /** Display a short Toast message to confirm a button was clicked. */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
