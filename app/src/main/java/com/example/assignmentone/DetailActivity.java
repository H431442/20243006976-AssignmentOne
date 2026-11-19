package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Read which section was selected from the Intent extra.
        Intent intent = getIntent();
        int sectionIndex = intent.getIntExtra(getString(R.string.extra_section_index), 0);

        // Look up the section's data in the arrays.xml resources.
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] images = getResources().getStringArray(R.array.string_array_images);
        String[] shortLabels = {
                getString(R.string.facilities),
                getString(R.string.events),
                getString(R.string.clubs),
                getString(R.string.support)
        };

        // Resolve the drawable resource for the section icon by name.
        String iconName = images[sectionIndex];
        int iconResId = getResources().getIdentifier(
                iconName, "drawable", getPackageName());

        // Update the UI with the selected section's information.
        ImageView detailIcon = findViewById(R.id.detailIcon);
        TextView headerTitle = findViewById(R.id.detailHeaderTitle);
        TextView contentTitle = findViewById(R.id.detailContentTitle);
        TextView contentText = findViewById(R.id.detailContentText);

        if (iconResId != 0) {
            detailIcon.setImageResource(iconResId);
        }
        headerTitle.setText(shortLabels[sectionIndex]);
        contentTitle.setText(titles[sectionIndex]);
        contentText.setText(contents[sectionIndex]);
    }
}
