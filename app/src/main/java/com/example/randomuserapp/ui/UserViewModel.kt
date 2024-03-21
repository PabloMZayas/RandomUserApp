package com.example.randomuserapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserapp.data.remote.api.ResultApiService
import com.example.randomuserapp.di.CoroutinesDispatchers
import com.example.randomuserapp.domain.BringUsersSavedUseCase
import com.example.randomuserapp.domain.GetUserInformationUseCase
import com.example.randomuserapp.domain.SaveUserUseCase
import com.example.randomuserapp.ui.models.UserModelUi
import com.example.randomuserapp.ui.models.UserRoomUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class UserViewModel @Inject constructor(
        private val getUserInformationUseCase: GetUserInformationUseCase,
        private val saveUserUseCase: SaveUserUseCase,
        private val bringUsersSavedUseCase: BringUsersSavedUseCase,
        private val dispatchers: CoroutinesDispatchers
) : ViewModel() {

    private var _userModelUi = MutableLiveData<UserModelUi>()
    val userModelUi get () = _userModelUi

    private var _messageError = MutableLiveData<String>()
    val messageError get () = _messageError

    private var _usersSaved = MutableLiveData<List<UserRoomUiModel>>()
    val usersSaved get() = _usersSaved

    fun getUserInformation() {
        viewModelScope.launch(dispatchers.io) {
            val result = getUserInformationUseCase.getUserInformation()
            withContext(dispatchers.main) {
                when (result) {
                    is ResultApiService.Success -> {
                        onSuccess(result.data)
                    }
                    is ResultApiService.Error -> {
                        onError(result.message)
                    }
                }
            }
        }
    }

    private fun onSuccess(data: UserModelUi) {
        _userModelUi.value = data
    }

    private fun onError(message: String) {
        _messageError.value = message
    }

    fun saveUser(userRoomModel: UserRoomUiModel) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserUseCase.saveUser(userRoomModel)
        }
    }

    fun bringUsersSaved() {
        viewModelScope.launch {
            _usersSaved.value = bringUsersSavedUseCase.bringUsersSaved()
        }
    }
}