package com.example.roomdatabase.RoomDB

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentDao {
    @Insert
    suspend fun insert(vararg student: Student){

    }

}