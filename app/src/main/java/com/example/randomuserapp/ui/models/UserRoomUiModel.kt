package com.example.randomuserapp.ui.models

import java.util.UUID

data class UserRoomUiModel(
        val id: String = UUID.randomUUID().toString(),
        val nameUi: NameUi,
        val pictureUi: String,
        val email: String
) {
    constructor(nameUi: NameUi, pictureUi: String, email: String)
            : this(UUID.randomUUID().toString(), nameUi, pictureUi, email)
}
