package com.example.roomdatabase.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.Factory.Dbfactroy
import com.example.roomdatabase.R
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.RoomDB.DataBaseStudent
import com.example.roomdatabase.View_Model.Dbviewmodel
import com.example.roomdatabase.databinding.ActivityLoginBinding
import com.example.roomdatabase.databinding.ActivityUserdetailsBinding

class Userdetails : AppCompatActivity() {
    private lateinit var binding: ActivityUserdetailsBinding
    lateinit var factroy: Dbfactroy
    lateinit var viewmodel: Dbviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_userdetails)
        factroy = Dbfactroy(DbRepojetry(DataBaseStudent.myobjct(this).studentdao()))
        viewmodel = ViewModelProvider(this, factroy)[Dbviewmodel::class.java]
    }
}