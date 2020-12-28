package com.tugas.movie_1485.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tugas.movie_1485.DatabaseHelper;
import com.tugas.movie_1485.FavoriteAdapter;
import com.tugas.movie_1485.Movie;
import com.tugas.movie_1485.R;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {

    RecyclerView rvMovie;
    private ArrayList<Movie> listMovie;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        rvMovie = view.findViewById(R.id.rv_movie_fav);
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseHelper db = new DatabaseHelper(getContext());
        listMovie = db.getAllFavorite();

        if (listMovie.size() != 0) {
            FavoriteAdapter adapter = new FavoriteAdapter(listMovie, getContext());
            rvMovie.setAdapter(adapter);
        }

        return view;
    }
}