package com.example.randomuserapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.randomuserapp.data.userroom.RandomUserDao
import com.example.randomuserapp.data.userroom.RandomUserDatabase
import com.example.randomuserapp.data.userroom.RandomUserDatabase.Companion.RANDOM_USER_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RandomUserModule {

    @Singleton
    @Provides
    fun providesRandomUserDao(db : RandomUserDatabase): RandomUserDao = db.getRandomUserDao()

    @Singleton
    @Provides
    fun provideDatabase(app: Application): RandomUserDatabase {
        return Room.databaseBuilder(app, RandomUserDatabase::class.java, RANDOM_USER_DATABASE)
                .fallbackToDestructiveMigration()
                .build()
    }
}