package com.example.randomuserapp.data.userroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RandomUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRandomUser(randomUserEntity: RandomUserEntity): Long

    @Query("SELECT * FROM random_user_entity")
    suspend fun getAllUsers(): List<RandomUserEntity>
}
