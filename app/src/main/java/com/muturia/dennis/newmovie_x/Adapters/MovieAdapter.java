package com.muturia.dennis.newmovie_x.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muturia.dennis.newmovie_x.R;
import com.muturia.dennis.newmovie_x.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private ArrayList<Movie> mMovie = new ArrayList<>();
    private Context mContext;
    private static final int MAX_HEIGHT = 400;
    private static final int MAX_WIDTH = 300;

    public MovieAdapter(Context context, ArrayList<Movie> movies){
        mContext = context;
        mMovie = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bindMovie(mMovie.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.myImage)
        ImageView myImage;
        @BindView(R.id.mainText)
        TextView Title;
        //@BindView(R.id.overview)TextView Overview;

        private Context mContext;

        public MovieViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMovie(Movie movie){
            Title.setText(movie.getMovieName());
            Picasso.with(mContext).load(movie.getImage()).resize(MAX_WIDTH,MAX_HEIGHT).centerCrop().into(myImage);

        }

    }
}
