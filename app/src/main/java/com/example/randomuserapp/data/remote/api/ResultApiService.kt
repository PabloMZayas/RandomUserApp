package com.example.randomuserapp.data.remote.api

import com.example.randomuserapp.ui.models.UserModelUi

sealed class ResultApiService {
    data class Success(val data: UserModelUi) : ResultApiService()
    data class Error(val message: String) : ResultApiService()
}
