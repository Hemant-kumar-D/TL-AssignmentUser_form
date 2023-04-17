package com.example.roomdatabase.View_Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.RoomDB.Student

class Dbviewmodel(private val repogetry:DbRepojetry):ViewModel(){
    suspend fun insertdata(student: Student){
        repogetry.insersdata(student)
    }
    suspend fun getdata(email:String,password:String):Boolean{
        return repogetry.getdata(email,password)
    }
}