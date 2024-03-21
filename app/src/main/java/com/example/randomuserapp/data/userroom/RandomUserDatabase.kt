package com.example.randomuserapp.data.userroom

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [RandomUserEntity::class], version = 1)
abstract class RandomUserDatabase: RoomDatabase() {

    abstract fun getRandomUserDao(): RandomUserDao

    companion object {
        const val RANDOM_USER_DATABASE = "random_user_database"
    }
}