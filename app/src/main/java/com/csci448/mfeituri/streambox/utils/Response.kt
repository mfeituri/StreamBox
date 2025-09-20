package com.csci448.mfeituri.streambox.utils


// using a sealed class here, kind of like an enum but a state wrapper for handling these different cases
// from our api response, its a generic class that can be used with any data type
sealed class Response<T> {
    class Success<T>(val data:T): Response<T>()
    class Error<T>(val error:Throwable?, val data:T? = null): Response<T>()
    class Loading<T>: Response<T>()



}