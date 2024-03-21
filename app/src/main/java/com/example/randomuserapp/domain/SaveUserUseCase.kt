package com.example.randomuserapp.domain

import com.example.randomuserapp.ui.models.UserRoomUiModel
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun saveUser(userRoomUiModel: UserRoomUiModel) = userRepository.saveUser(userRoomUiModel)
}
