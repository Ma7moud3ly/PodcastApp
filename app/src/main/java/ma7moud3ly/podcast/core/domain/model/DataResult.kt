package ma7moud3ly.podcast.core.domain.model

sealed interface DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>
    data class Error(val exception: DataException) : DataResult<Nothing>
}


inline fun <T> DataResult<T>.fold(
    onSuccess: (T) -> Unit,
    onFailure: (DataException) -> Unit
) {
    when (this) {
        is DataResult.Success -> onSuccess(data)
        is DataResult.Error -> onFailure(exception)
    }
}