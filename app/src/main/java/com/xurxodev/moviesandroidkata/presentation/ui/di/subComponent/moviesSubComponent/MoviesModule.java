package com.xurxodev.moviesandroidkata.presentation.ui.di.subComponent.moviesSubComponent;

import com.xurxodev.moviesandroidkata.domain.executor.Executor;
import com.xurxodev.moviesandroidkata.domain.executor.MainThread;
import com.xurxodev.moviesandroidkata.domain.boundary.MovieRepository;
import com.xurxodev.moviesandroidkata.presentation.presenter.MoviesPresenter;
import com.xurxodev.moviesandroidkata.presentation.ui.di.scope.MoviesScope;
import com.xurxodev.moviesandroidkata.presentation.ui.fragment.MoviesFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {

    @Provides
    @MoviesScope
    MoviesPresenter providesMoviesPresenter(MoviesFragment moviesFragment, MovieRepository movieRepository,
                                            MainThread mainThread, Executor backgroundExecutor) {
        return new MoviesPresenter(moviesFragment, movieRepository, mainThread, backgroundExecutor);
    }

}
