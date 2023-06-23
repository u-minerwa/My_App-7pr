package com.example.pract_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pract_7.adapter.CategoryAdapter;
import com.example.pract_7.adapter.CourseAdapter;
import com.example.pract_7.model.Category;
import com.example.pract_7.model.CourseM;

import java.util.ArrayList;
import java.util.List;

public class Courses extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Курсы"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        List<CourseM> courseMList = new ArrayList<>();
        courseMList.add(new CourseM(1, "java_logo_2", "Профессия Java\nразработчик", "26 июня", "начальный", "#424345", "Test"));
        courseMList.add(new CourseM(2, "python_logo_2", "Профессия Python\nразработчик", "5 сентября", "начальный", "#9FA52D", "Test"));
        // courseMList.add(new CourseM(3, ""));
        // courseMList.add(new CourseM(4, ""));

        setCourseMRecycler(courseMList);

    }

    private void setCourseMRecycler(List<CourseM> courseMList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseMList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}

