package com.example.pract_7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        int imageId = context.getResources().getIdentifier(courseMS.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImageFull.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return courseMS.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        LinearLayout courseBg;
        ImageView courseImageFull;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseImageFull = itemView.findViewById(R.id.courseImageFull);
        }
    }
}
