package com.example.projectnew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.MyViewHolder>{
    Context context;
    Activity activity;
    private ArrayList book_id, book_title , author , publish_year, book_rating;

    Adaptor(Activity activity,
            Context context,
            ArrayList book_id,
            ArrayList book_title,
            ArrayList author,
            ArrayList publish_year,
            ArrayList book_rating){

        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.publish_year = publish_year;
        this.book_rating = book_rating;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptor.MyViewHolder holder, int position) {
        holder.book_id_view.setText(String.valueOf(book_id.get(position)));
        holder.book_title_view.setText(String.valueOf(book_title.get(position)));
        holder.author_view.setText(String.valueOf(author.get(position)));
        holder.year_view.setText(String.valueOf(publish_year.get(position)));
        holder.book_rating_view.setText(String.valueOf(book_rating.get(position)));
        holder.mainLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context,UpdateActivity.class);
            intent.putExtra("id", String.valueOf(book_id.get(position)));
            intent.putExtra("title", String.valueOf(book_title.get(position)));
            intent.putExtra("author", String.valueOf(author.get(position)));
            intent.putExtra("year", String.valueOf(publish_year.get(position)));
            intent.putExtra("rating", String.valueOf(book_rating.get(position)));
            activity.startActivityForResult(intent,1);
        });
    }

    @Override
    public int getItemCount() {
        return  book_id.size();
    }

    public class MyViewHolder  extends  RecyclerView.ViewHolder{
        TextView book_id_view, book_title_view , author_view, year_view, book_rating_view;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_view = itemView.findViewById(R.id.book_id_view);
            book_title_view = itemView.findViewById(R.id.book_title_view);
            author_view = itemView.findViewById(R.id.author_view);
            year_view = itemView.findViewById(R.id.year_view);
            book_rating_view = itemView.findViewById(R.id.book_rating_view);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
