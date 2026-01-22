package ma7moud3ly.podcast.home.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ma7moud3ly.podcast.core.di.NetworkModule.RetrofitApi
import ma7moud3ly.podcast.core.di.NetworkModule.RetrofitKey
import ma7moud3ly.podcast.home.data.api.SectionsApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDsModule {
    @Singleton
    @Provides
    fun provideSectionsService(
        @RetrofitApi(RetrofitKey.HOME)
        retrofit: Retrofit
    ): SectionsApiService {
        return retrofit.create(SectionsApiService::class.java)
    }
}