package com.example.roomdatabase.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 3)
 abstract class DataBaseStudent(): RoomDatabase() {
     abstract  fun studentdao():StudentDao
     companion object {
         @Volatile
         var INSTECE: DataBaseStudent? = null
         fun myobjct(context: Context): DataBaseStudent {
             var intence = INSTECE
             synchronized(this) {
                 if (intence == null) {
                     intence=Room.databaseBuilder(context, DataBaseStudent::class.java, "Mydatabase2")
                         .build()
                     INSTECE = intence
                 }

             }
             return INSTECE!!

         }
     }
}