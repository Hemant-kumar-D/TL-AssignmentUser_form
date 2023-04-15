package com.example.roomdatabase.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.View_Model.Dbviewmodel

class Dbfactroy(private val repogetry: DbRepojetry):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Dbviewmodel::class.java)){
            return Dbviewmodel(repogetry) as T
        }
        throw IllegalArgumentException("Unknown class")
    }


}