package com.example.randomuserapp.domain

import com.example.randomuserapp.data.remote.RemoteDataBase
import com.example.randomuserapp.data.remote.api.ResultApiService
import javax.inject.Inject

class UserRepository @Inject constructor(private val remoteDataBase: RemoteDataBase) {

    suspend fun getUserInformation(): ResultApiService = remoteDataBase.getUserInformation()
}
