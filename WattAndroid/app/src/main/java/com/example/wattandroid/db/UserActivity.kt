package com.example.wattandroid.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "activity_table")
class UserActivity(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "bpm") val word: Int
)

@Dao
interface UserActivityDao {

    @Query("SELECT * FROM activity_table ORDER BY id DESC")
    fun getAllActivityPoints(): Flow<List<UserActivity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: UserActivity)

    @Query("DELETE FROM activity_table")
    suspend fun deleteAll()
}

