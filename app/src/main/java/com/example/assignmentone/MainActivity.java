package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Handle a section button click: show feedback, then start DetailActivity
     * with an Intent carrying which section was selected.
     *
     * @param sectionIndex index into the CampusLife section arrays
     */
    private void openSection(int sectionIndex) {
        String[] labels = getResources().getStringArray(R.array.string_array_titles);
        showToast(getString(R.string.clicked_message, labels[sectionIndex]));

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(getString(R.string.extra_section_index), sectionIndex);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The same view IDs exist in the portrait and landscape layouts,
        // so these listeners work in either orientation.
        ImageButton facilitiesButton = findViewById(R.id.btnFacilities);
        ImageButton eventsButton = findViewById(R.id.btnEvents);
        ImageButton clubsButton = findViewById(R.id.btnClubs);
        ImageButton supportButton = findViewById(R.id.btnSupport);

        facilitiesButton.setOnClickListener(v -> openSection(0));
        eventsButton.setOnClickListener(v -> openSection(1));
        clubsButton.setOnClickListener(v -> openSection(2));
        supportButton.setOnClickListener(v -> openSection(3));
    }

    /** Display a short Toast message to confirm a button was clicked. */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
