package ma7moud3ly.podcast.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import ma7moud3ly.podcast.BuildConfig
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        explicitNulls = false
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG)
                setLevel(HttpLoggingInterceptor.Level.BODY)
            else
                setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }


    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RetrofitApi(val key: RetrofitKey)
    enum class RetrofitKey { HOME, SEARCH }

    @Provides
    @Singleton
    @RetrofitApi(RetrofitKey.HOME)
    fun provideRetrofitWithApi1(json: Json, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_HOME)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    @RetrofitApi(RetrofitKey.SEARCH)
    fun provideRetrofitWithApi2(json: Json, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_SEARCH)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}