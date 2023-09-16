package com.xurxodev.moviesandroidkata.presentation.ui.di.subComponent.movieDetailSubComponent;

import com.xurxodev.moviesandroidkata.presentation.ui.di.scope.MoviesScope;
import com.xurxodev.moviesandroidkata.presentation.ui.fragment.MovieDetailFragment;
import dagger.BindsInstance;
import dagger.Subcomponent;

@MoviesScope
@Subcomponent(modules = {MovieDetailModule.class})
public interface MovieDetailSubComponent {

    void inject(MovieDetailFragment movieDetailFragment);

    @Subcomponent.Factory
    interface Factory {
        MovieDetailSubComponent create(@BindsInstance MovieDetailFragment movieDetailFragment);
    }
}
