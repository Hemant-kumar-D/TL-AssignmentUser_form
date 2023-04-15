package com.example.roomdatabase.Repojetry

import com.example.roomdatabase.RoomDB.Student
import com.example.roomdatabase.RoomDB.StudentDao

class DbRepojetry(private val studentDao: StudentDao){
    suspend fun insersdata(student: Student){
        studentDao.insert(student)
    }

}