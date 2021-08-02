package com.cineasteJE.android.network

interface NetworkCallback {
    fun onFailure()
    fun onSuccess(response: NetworkResponse)
}