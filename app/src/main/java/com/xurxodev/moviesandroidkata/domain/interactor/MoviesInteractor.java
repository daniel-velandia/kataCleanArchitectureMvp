package com.xurxodev.moviesandroidkata.domain.interactor;

import com.xurxodev.moviesandroidkata.domain.executor.Executor;
import com.xurxodev.moviesandroidkata.domain.executor.MainThread;
import com.xurxodev.moviesandroidkata.domain.model.Movie;
import com.xurxodev.moviesandroidkata.domain.boundary.MovieRepository;

import java.util.List;

public class MoviesInteractor {

    private Callback moviesPresenter;
    private MovieRepository movieRepository;
    private MainThread mainHandler;
    private Executor backgroundExecutor;

    public MoviesInteractor(Callback moviesPresenter, MovieRepository movieRepository, MainThread mainHandler,
                            Executor backgroundExecutor) {
        this.moviesPresenter = moviesPresenter;
        this.movieRepository = movieRepository;
        this.mainHandler = mainHandler;
        this.backgroundExecutor = backgroundExecutor;
    }

    public void execute() {

        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<Movie> movies = movieRepository.getMovies();

                if(movies == null || movies.size() == 0) {
                    notifyError("error while read movies");
                }

                postMovies(movies);
            }
        });

    }

    private void notifyError(String error) {
        mainHandler.execute(new Runnable() {
            @Override
            public void run() {
                moviesPresenter.onRetrievalFailed(error);
            }
        });
    }

    private void postMovies(List<Movie> movies) {
        mainHandler.execute(new Runnable() {
            @Override
            public void run() {
                moviesPresenter.onMoviesRetrieved(movies);
            }
        });
    }

    public interface Callback {

        void onMoviesRetrieved(List<Movie> movies);
        void onRetrievalFailed(String message);
    }
}
