package ma7moud3ly.podcast.search.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import ma7moud3ly.podcast.core.di.Dispatcher
import ma7moud3ly.podcast.core.di.DispatcherKey
import ma7moud3ly.podcast.search.data.datasource.remote.SearchRemoteDs
import ma7moud3ly.podcast.search.data.repository.SearchRepositoryImpl
import ma7moud3ly.podcast.search.domain.repository.SearchRepository

@InstallIn(ViewModelComponent::class)
@Module
object ReposModule {
    @ViewModelScoped
    @Provides
    fun provideSearchRepositoryImpl(
        searchRemoteDs: SearchRemoteDs,
        @Dispatcher(DispatcherKey.IO) ioDispatcher: CoroutineDispatcher
    ): SearchRepository {
        return SearchRepositoryImpl(searchRemoteDs, ioDispatcher)
    }
}