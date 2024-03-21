package com.example.randomuserapp.domain

import com.example.randomuserapp.data.remote.RemoteDataBase
import com.example.randomuserapp.data.remote.api.ResultApiService
import com.example.randomuserapp.data.userroom.RandomUserDao
import com.example.randomuserapp.data.userroom.RandomUserDatabase
import com.example.randomuserapp.data.userroom.RandomUserEntity
import com.example.randomuserapp.data.userroom.toRandomUserEntity
import com.example.randomuserapp.data.userroom.toUserRoomUiModel
import com.example.randomuserapp.ui.models.UserRoomUiModel
import javax.inject.Inject

class UserRepository @Inject constructor(private val remoteDataBase: RemoteDataBase,
                                         private val randomUserDao: RandomUserDao) {

    suspend fun getUserInformation(): ResultApiService = remoteDataBase.getUserInformation()

    suspend fun saveUser(userRoomUiModel: UserRoomUiModel) = randomUserDao.insertRandomUser(userRoomUiModel.toRandomUserEntity())

    suspend fun bringUsersSaved():List<UserRoomUiModel> =
            randomUserDao.getAllUsers().map { it.toUserRoomUiModel() }
}
