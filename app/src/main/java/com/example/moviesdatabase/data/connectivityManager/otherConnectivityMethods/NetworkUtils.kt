package com.example.moviesdatabase.data.connectivityManager.otherConnectivityMethods

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface NetworkUtils {
    fun hasNetworkAccess(): Boolean
}

class NetworkUtilsImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : NetworkUtils {
    override fun hasNetworkAccess(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }

    //TODO: show on view that there is no connectivity.
}