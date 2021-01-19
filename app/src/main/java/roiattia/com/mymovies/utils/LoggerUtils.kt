package roiattia.com.mymovies.utils

import timber.log.Timber

class LoggerUtils {

    companion object {

        fun i(message: String){
            Timber.i(message)
        }

        fun d(message: String){
            Timber.d(message)
        }

        fun v(message: String){
            Timber.v(message)
        }

        fun w(message: String){
            Timber.w(message)
        }

        fun e(message: String){
            Timber.e(message)
        }

    }
}