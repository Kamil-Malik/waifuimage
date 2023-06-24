package com.lelestacia.waifuimage.core.data

import android.content.Context
import java.net.UnknownHostException

class ErrorParserUtil(
    private val context: Context
) {

    operator fun invoke(t: Throwable): String {
        return when(t) {
            is UnknownHostException -> context.getString(R.string.no_internet_connection)
            else -> t.message ?: context.getString(R.string.unknown_error)
        }
    }
}