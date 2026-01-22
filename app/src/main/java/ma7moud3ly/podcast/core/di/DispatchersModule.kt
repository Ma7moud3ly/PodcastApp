package ma7moud3ly.podcast.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: DispatcherKey)
enum class DispatcherKey { IO,COMPUTATION,MAIN }

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @Dispatcher(DispatcherKey.IO)
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(DispatcherKey.MAIN)
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Dispatcher(DispatcherKey.COMPUTATION)
    fun provideComputationDispatcher(): CoroutineDispatcher = Dispatchers.Default
}