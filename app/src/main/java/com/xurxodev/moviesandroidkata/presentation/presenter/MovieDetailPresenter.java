package com.xurxodev.moviesandroidkata.presentation.presenter;

import com.xurxodev.moviesandroidkata.domain.boundary.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.executor.Executor;
import com.xurxodev.moviesandroidkata.domain.executor.MainThread;
import com.xurxodev.moviesandroidkata.domain.interactor.MovieDetailInteractor;
import com.xurxodev.moviesandroidkata.domain.model.Movie;

public class MovieDetailPresenter implements MovieDetailInteractor.Callback{

    private Callback movieDetailFragment;
    private MovieDetailInteractor movieDetailInteractor;

    public MovieDetailPresenter(Callback movieDetailFragment, MovieRepository movieRepository, MainThread mainThread,
                                Executor backgroundExecutor) {
        this.movieDetailFragment = movieDetailFragment;
        this.movieDetailInteractor = new MovieDetailInteractor(this, movieRepository, mainThread,
                backgroundExecutor);
    }

    public void onCreateView(int position) {
        movieDetailFragment.loadingMovie();

        movieDetailInteractor.execute(position);
    }

    @Override
    public void onMovieRetrieved(Movie movie) {
        movieDetailFragment.loadedMovie(movie);
    }

    @Override
    public void onRetrievalFailed(String error) {
        movieDetailFragment.showError(error);
    }

    public interface Callback {

        void loadingMovie();
        void loadedMovie(Movie movie);
        void showError(String error);

    }
}
