package ma7moud3ly.podcast.search.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ma7moud3ly.podcast.core.di.NetworkModule.RetrofitApi
import ma7moud3ly.podcast.core.di.NetworkModule.RetrofitKey
import ma7moud3ly.podcast.search.data.api.SearchApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDsModule {
    @Singleton
    @Provides
    fun provideSearchService(
        @RetrofitApi(RetrofitKey.SEARCH)
        retrofit: Retrofit
    ): SearchApiService {
        return retrofit.create(SearchApiService::class.java)
    }
}