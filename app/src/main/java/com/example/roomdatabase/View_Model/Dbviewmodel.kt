package com.example.roomdatabase.View_Model

import androidx.lifecycle.ViewModel
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.RoomDB.Student

class Dbviewmodel(private val repogetry:DbRepojetry):ViewModel(){
    suspend fun insertdata(student: Student){
        repogetry.insersdata(student)

    }
}