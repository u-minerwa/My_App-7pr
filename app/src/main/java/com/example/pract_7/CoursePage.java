package com.example.pract_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout coursePageBg = findViewById(R.id.coursePageBg);
        ImageView coursePageImage = findViewById(R.id.coursePageImg);
        TextView coursePageTitle = findViewById(R.id.coursePageTitle);
        TextView coursePageDate = findViewById(R.id.coursePageDate);
        TextView coursePageLevel = findViewById(R.id.coursePageLevel);
        TextView coursePageText = findViewById(R.id.coursePageText);

        coursePageBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        coursePageImage.setImageResource(getIntent().getIntExtra("courseImageFull", 0));
        coursePageTitle.setText(getIntent().getStringExtra("courseTitle"));
        coursePageDate.setText(getIntent().getStringExtra("courseDate"));
        coursePageLevel.setText(getIntent().getStringExtra("courseLevel"));
        coursePageText.setText(getIntent().getStringExtra("courseText"));
    }
}

