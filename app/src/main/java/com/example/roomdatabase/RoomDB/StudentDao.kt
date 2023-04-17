package com.example.roomdatabase.RoomDB

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    suspend fun insert(vararg student: Student)
    @Query("SELECT EXISTS(SELECT*FROM Student Where Email=:email AND Password=:password)")
    suspend fun  getdata(email:String,password:String):Boolean

}