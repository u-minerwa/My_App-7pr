package com.example.pract_7.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pract_7.CoursePage;
import com.example.pract_7.R;
import com.example.pract_7.model.CourseM;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    Context context;
    List<CourseM> courseMS;

    public CourseAdapter(Context context, List<CourseM> courseMS) {
        this.context = context;
        this.courseMS = courseMS;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View coursItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(coursItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courseMS.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(courseMS.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImageFull.setImageResource(imageId);

        holder.courseTitle.setText(courseMS.get(position).getTitle());
        holder.courseDate.setText(courseMS.get(position).getDate());
        holder.courseLevel.setText(courseMS.get(position).getLevel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoursePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity)context,
                        new Pair<View, String>(holder.courseImageFull, "courseImageFull"));

                intent.putExtra("courseBg", Color.parseColor(courseMS.get(position).getColor()));
                intent.putExtra("courseImageFull", imageId);
                intent.putExtra("courseTitle", courseMS.get(position).getTitle());
                intent.putExtra("courseDate", courseMS.get(position).getDate());
                intent.putExtra("courseLevel", courseMS.get(position).getLevel());
                intent.putExtra("courseText", courseMS.get(position).getText());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseMS.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        CardView courseBg;
        ImageView courseImageFull;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseImageFull = itemView.findViewById(R.id.courseImageFull);
            courseBg = itemView.findViewById(R.id.courseBg);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseLevel = itemView.findViewById(R.id.courseLevel);
        }
    }
}
