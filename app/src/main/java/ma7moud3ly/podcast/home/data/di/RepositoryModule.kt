package ma7moud3ly.podcast.home.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ma7moud3ly.podcast.home.data.api.SectionsApiService
import ma7moud3ly.podcast.home.data.repository.SectionsRepositoryImpl
import ma7moud3ly.podcast.home.domain.repository.SectionsRepository

@InstallIn(ViewModelComponent::class)
@Module
object ReposModule {
    @ViewModelScoped
    @Provides
    fun provideSectionsRepositoryImpl(
        sectionsApiServices: SectionsApiService
    ): SectionsRepository {
        return SectionsRepositoryImpl(sectionsApiServices)
    }
}