package com.xurxodev.moviesandroidkata.presentation.presenter;

import com.xurxodev.moviesandroidkata.domain.executor.Executor;
import com.xurxodev.moviesandroidkata.domain.executor.MainThread;
import com.xurxodev.moviesandroidkata.domain.interactor.MoviesInteractor;
import com.xurxodev.moviesandroidkata.domain.model.Movie;
import com.xurxodev.moviesandroidkata.domain.boundary.MovieRepository;

import java.util.List;

import javax.inject.Inject;

public class MoviesPresenter implements MoviesInteractor.Callback {

    private Callback moviesFragment;
    private MoviesInteractor moviesInteractor;

    @Inject
    public MoviesPresenter(Callback moviesFragment, MovieRepository movieRepository, MainThread mainThread,
                           Executor backgroundExecutor) {
        this.moviesFragment = moviesFragment;
        this.moviesInteractor = new MoviesInteractor(this, movieRepository, mainThread,
                backgroundExecutor);
    }

    public void onCreateView() {
        moviesFragment.initializeRefreshButton();
        moviesFragment.initializeAdapter();
        moviesFragment.initializeRecyclerView();

        moviesFragment.loadingMovies();

        moviesInteractor.execute();
    }

    public void onRefreshMovies() {
        moviesFragment.loadingMovies();
        moviesInteractor.execute();
    }

    @Override
    public void onMoviesRetrieved(List<Movie> movies) {
        moviesFragment.loadedMovies(movies);
    }

    @Override
    public void onRetrievalFailed(String error) {
        moviesFragment.showError(error);
    }

    public interface Callback {
        void initializeRefreshButton();
        void initializeAdapter();
        void initializeRecyclerView();

        void loadingMovies();
        void loadedMovies(List<Movie> movies);
        void showError(String error);
    }

}
