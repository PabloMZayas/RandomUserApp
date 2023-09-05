package com.example.randomuserapp.domain

import com.example.randomuserapp.data.remote.api.ResultApiService
import javax.inject.Inject

class GetUserInformationUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun getUserInformation(): ResultApiService = userRepository.getUserInformation()
}