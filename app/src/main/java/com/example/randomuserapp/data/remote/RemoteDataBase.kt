package com.example.randomuserapp.data.remote

import com.example.randomuserapp.data.models.toUserModelUI
import com.example.randomuserapp.data.remote.api.ResultApiService
import com.example.randomuserapp.data.remote.api.ApiService
import java.lang.Exception
import javax.inject.Inject

class RemoteDataBase @Inject constructor(private val apiService: ApiService) {

    suspend fun getUserInformation(): ResultApiService {
        return try {
            val response = apiService.getUser()
            val data = response.body()
            if (data != null) ResultApiService.Success(data.toUserModelUI())
            else ResultApiService.Error("Response body is null")
        } catch (e: Exception) {
            ResultApiService.Error("An error occurred: ${e.message}")
        }
    }
}
