package com.example.randomuserapp.data.userroom

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.randomuserapp.ui.models.NameUi
import com.example.randomuserapp.ui.models.UserRoomUiModel

@Entity(tableName = "random_user_entity")
data class RandomUserEntity (
        @PrimaryKey (autoGenerate = false)
        @ColumnInfo(name = "id")
        val id: String,

        @Embedded
        val name: NameUi,

        @ColumnInfo(name = "picture")
        val picture: String,

        @ColumnInfo(name = "email")
        val email: String
        )

fun RandomUserEntity.toUserRoomUiModel() = UserRoomUiModel(
        id = id,
        nameUi = name,
        pictureUi = picture,
        email = email
)

fun UserRoomUiModel.toRandomUserEntity() = RandomUserEntity(
        id = id,
        name = nameUi,
        picture = pictureUi,
        email = email
)
