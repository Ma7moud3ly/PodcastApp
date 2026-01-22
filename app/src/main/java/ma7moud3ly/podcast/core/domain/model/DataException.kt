package ma7moud3ly.podcast.core.domain.model

sealed class DataException : Exception() {
    class NoInternet : DataException()
    class ServerError : DataException()
    class Unauthorized(override val message: String) : DataException()
    class NotFound : DataException()
    class Unknown(val originalMessage: String?) : DataException()
}