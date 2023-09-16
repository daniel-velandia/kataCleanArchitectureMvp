package com.xurxodev.moviesandroidkata.domain.interactor;

import com.xurxodev.moviesandroidkata.domain.executor.Executor;
import com.xurxodev.moviesandroidkata.domain.executor.MainThread;
import com.xurxodev.moviesandroidkata.domain.boundary.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

public class MovieDetailInteractor {

    private Callback movieDetailPresenter;
    private MovieRepository movieRepository;
    private MainThread mainThread;
    private Executor backgroundExecutor;

    public MovieDetailInteractor(Callback movieDetailPresenter, MovieRepository movieRepository, MainThread mainThread,
                                 Executor backgroundExecutor) {
        this.movieDetailPresenter = movieDetailPresenter;
        this.movieRepository = movieRepository;
        this.mainThread = mainThread;
        this.backgroundExecutor = backgroundExecutor;
    }

    public void execute(int position) {

        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Movie movie = movieRepository.getMovie(position);

                if(movie == null) {
                    notifyError("error while read movie");
                }

                postMovie(movie);
            }
        });

    }

    private void notifyError(String error) {
        mainThread.execute(new Runnable() {
            @Override
            public void run() {
                movieDetailPresenter.onRetrievalFailed(error);
            }
        });
    }

    private void postMovie(Movie movie) {
        mainThread.execute(new Runnable() {
            @Override
            public void run() {
                movieDetailPresenter.onMovieRetrieved(movie);
            }
        });
    }

    public interface Callback {

        void onMovieRetrieved(Movie movie);
        void onRetrievalFailed(String error);
    }
}
