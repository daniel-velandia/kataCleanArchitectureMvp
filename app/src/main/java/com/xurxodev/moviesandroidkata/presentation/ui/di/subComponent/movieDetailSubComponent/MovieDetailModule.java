package com.xurxodev.moviesandroidkata.presentation.ui.di.subComponent.movieDetailSubComponent;

import com.xurxodev.moviesandroidkata.domain.boundary.MovieRepository;
import com.xurxodev.moviesandroidkata.domain.executor.Executor;
import com.xurxodev.moviesandroidkata.domain.executor.MainThread;
import com.xurxodev.moviesandroidkata.presentation.presenter.MovieDetailPresenter;
import com.xurxodev.moviesandroidkata.presentation.ui.di.scope.MoviesScope;
import com.xurxodev.moviesandroidkata.presentation.ui.fragment.MovieDetailFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class MovieDetailModule {

    @Provides
    @MoviesScope
    MovieDetailPresenter providesMovieDetailPresenter(MovieDetailFragment movieDetailFragment,
                                                      MovieRepository movieRepository,
                                                      MainThread mainThread, Executor backgroundExecutor) {
        return new MovieDetailPresenter(movieDetailFragment, movieRepository, mainThread, backgroundExecutor);
    }
}
