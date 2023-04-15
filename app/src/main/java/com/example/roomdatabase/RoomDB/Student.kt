package com.example.roomdatabase.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
   @PrimaryKey val SRNU:Int,
   @ColumnInfo("FirstName") val Fname:String,
    @ColumnInfo("LastName")val LastName:String,
   @ColumnInfo("Mo.No") val Monu:String)
