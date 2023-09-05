package com.example.randomuserapp.data.remote.api

import com.example.randomuserapp.data.models.UserModelData
import com.example.randomuserapp.data.remote.api.UserEndPoint.GET.USER_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(USER_END_POINT)
    suspend fun getUser(): Response<UserModelData>
}
