package ma7moud3ly.podcast.core.data.mapper

import ma7moud3ly.podcast.core.domain.model.DataException

fun Throwable.toDataException(): DataException {
    return when (this) {
        // 1. Network / Connectivity issues
        is java.net.UnknownHostException,
        is java.net.ConnectException,
        is java.net.SocketTimeoutException -> DataException.NoInternet()

        // 2. HTTP Server/API issues
        is retrofit2.HttpException -> {
            when (this.code()) {
                401 -> DataException.Unauthorized("Session expired")
                404 -> DataException.NotFound()
                in 500..599 -> DataException.ServerError()
                else -> DataException.Unknown(this.message())
            }
        }

        // 3. Fallback for anything else
        else -> DataException.Unknown(this.localizedMessage)
    }
}
