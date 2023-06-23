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
    static CourseAdapter courseAdapter;
    static List<CourseM> courseMList = new ArrayList<>();
    static List<CourseM> fullCourseMList = new ArrayList<>();

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

        courseMList.add(new CourseM(1, "java_logo_2", "Профессия Java\nразработчик", "26 июня", "начальный", "#424345",
                "Программа обучения Java рассчитана на новичков в данной сфере. За программу вы изучите построение\n" +
                        "графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Android-приложений\n" +
                        "и отлично изучите сам язык Java!", 2));
        courseMList.add(new CourseM(2, "python_logo_2", "Профессия Python\nразработчик", "5 сентября", "начальный", "#9FA52D",
                "Программа обучения Python рассчитана на новичков в данной сфере. За программу вы изучите построение\n" +
                        "графического пользовательского интерфейса под ПК, разработку нейронных сетей, изучите построение полноценных приложений\n" +
                        "и отлично изучите сам язык Python!", 4));
        // courseMList.add(new CourseM(3, ""));
        // courseMList.add(new CourseM(4, ""));

        fullCourseMList.addAll(courseMList);

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

    public static void showCoursesByCategory(int category){
        courseMList.clear();
        courseMList.addAll(fullCourseMList);

        List<CourseM> filterCourses = new ArrayList<>();
        for (CourseM c: courseMList){
            if(c.getCategory() == category){
                filterCourses.add(c);
            }
            courseMList.clear();
            courseMList.addAll(filterCourses);

            courseAdapter.notifyDataSetChanged();
        }
    }
}

