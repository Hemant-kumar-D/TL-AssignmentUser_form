package com.example.roomdatabase.Repojetry

import androidx.lifecycle.LiveData
import com.example.roomdatabase.RoomDB.Student
import com.example.roomdatabase.RoomDB.StudentDao

class DbRepojetry(private val studentDao: StudentDao){
    suspend fun insersdata(student: Student){
        studentDao.insert(student)
    }
    suspend fun getdata(email:String,password:String):Boolean{
     return studentDao.getdata(email,password)

    }



}