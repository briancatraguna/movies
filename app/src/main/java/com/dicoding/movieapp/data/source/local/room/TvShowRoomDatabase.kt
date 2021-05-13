package com.dicoding.movieapp.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TvShowsRoomEntity::class],version = 1)
abstract class TvShowRoomDatabase: RoomDatabase() {
    abstract fun tvShowsStarredDao(): TvShowsStarredDao

    companion object{
        @Volatile
        private var INSTANCE: TvShowRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): TvShowRoomDatabase{
            if (INSTANCE == null){
                synchronized(TvShowRoomDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    TvShowRoomDatabase::class.java,"show_database").build()
                }
            }
            return INSTANCE as TvShowRoomDatabase
        }

    }

}