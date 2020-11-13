package com.example.wattandroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(UserActivity::class), version = 1, exportSchema = false)
public abstract class ActivityPointRoomDatabase : RoomDatabase() {

    abstract fun userActivityDao(): UserActivityDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ActivityPointRoomDatabase? = null

        fun getDatabase(context: Context): ActivityPointRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ActivityPointRoomDatabase::class.java,
                        "activity_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}