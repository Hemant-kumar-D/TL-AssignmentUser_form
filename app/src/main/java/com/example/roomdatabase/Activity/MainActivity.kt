package com.example.roomdatabase.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.Factory.Dbfactroy
import com.example.roomdatabase.R
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.RoomDB.DataBaseStudent
import com.example.roomdatabase.RoomDB.Student
import com.example.roomdatabase.ViewModel.Dbviewmodel
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var Factory: Dbfactroy
    lateinit var viewmodel: Dbviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Factory = Dbfactroy(DbRepojetry(DataBaseStudent.myobjct(this).studentdao()))
        viewmodel = ViewModelProvider(this, Factory)[Dbviewmodel::class.java]


        val toolbar=binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        viewmodel.nameerror.observe(this, Observer {
            binding.editFname.setError(it)
        })
        viewmodel.mobile.observe(this, Observer {
            binding.editMobile.setError(it)
        })
        viewmodel.Emailerr.observe(this, Observer {
            binding.editEmail.setError(it)
        })
        viewmodel.Passworderr.observe(this, Observer {
            binding.editPassword.setError(it)
        })
        viewmodel.nameerror.observe(this, Observer {
            binding.editConpassword.setError(it)
        })


    }
    fun Loginbutton(view:View) {
//        if(binding.editMobile.text.toString().length!=10){
//            binding.editMobile.setError("Fill valid Mo.Number")
//
//        }
//        else if(!Patterns.EMAIL_ADDRESS.matcher(binding.editEmail.text).matches()){
//            binding.editEmail.setError("Fill valid Email")
//        }
//        else if(binding.editPassword.text.toString().isEmpty()){
//            binding.editPassword.setError("fill this field")
//        }
//        else if(binding.editConpassword.text.toString().isEmpty()){
//            binding.editConpassword.setError("fill this field")
//        }
//        else if(!binding.editPassword.text.toString().equals(binding.editConpassword.text.toString())) {
//            binding.editConpassword.setError("password does not match")
//        }
//        else {
//            CoroutineScope(Dispatchers.IO).launch {
//
//                viewmodel.(
//                    Student(
//                        0,
//                        binding.editFname.text.toString(),
//                        binding.editMobile.text.toString(),
//                        binding.editEmail.text.toString(),
//                        binding.editPassword.text.toString(),
//                        binding.editConpassword.text.toString()
//                    )
//                )
//                startActivity(Intent(this@MainActivity, Login_Activity::class.java))
//            }
//        }
        CoroutineScope(Dispatchers.IO).launch {
            viewmodel.submitragistration(
                Student(
                    0,
                    binding.editFname.text.toString(),
                    binding.editMobile.text.toString(),
                    binding.editEmail.text.toString(),
                    binding.editPassword.text.toString(),
                    binding.editConpassword.text.toString()
                )
            )
        }
    }
}


