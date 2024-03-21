package com.example.randomuserapp.domain

import com.example.randomuserapp.ui.models.UserRoomUiModel
import javax.inject.Inject

class BringUsersSavedUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun bringUsersSaved(): List<UserRoomUiModel> = userRepository.bringUsersSaved()
}