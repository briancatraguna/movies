package com.dicoding.movieapp.data.source.local.room.shows

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.movieapp.data.source.local.room.movies.MovieRoomDatabase

@Database(entities = [TvShowsRoomEntity::class],version = 1,exportSchema = false)
abstract class TvShowRoomDatabase: RoomDatabase() {
    abstract fun tvShowsStarredDao(): TvShowsStarredDao

    companion object{
        @Volatile
        private var INSTANCE: TvShowRoomDatabase? = null

        fun getDatabase(context: Context): TvShowRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TvShowRoomDatabase::class.java,
                        "show_database"
                )
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                return instance
            }
        }

    }

}