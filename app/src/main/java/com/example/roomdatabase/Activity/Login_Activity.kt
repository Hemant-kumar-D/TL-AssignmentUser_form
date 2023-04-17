package com.example.roomdatabase.Activity

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.Factory.Dbfactroy
import com.example.roomdatabase.R
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.RoomDB.DataBaseStudent
import com.example.roomdatabase.RoomDB.Student
import com.example.roomdatabase.View_Model.Dbviewmodel
import com.example.roomdatabase.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Login_Activity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    lateinit var factroy:Dbfactroy
    lateinit var viewmodel:Dbviewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        factroy = Dbfactroy(DbRepojetry(DataBaseStudent.myobjct(this).studentdao()))
        viewmodel = ViewModelProvider(this, factroy)[Dbviewmodel::class.java]
        binding.btnSingLogin.setOnClickListener {
            if(binding.editEmail.editText?.text.toString().isEmpty()&&binding.editPassword.editText?.text.toString().isEmpty()){
                binding.editEmail.editText?.setError("Fill Email")
                binding.editPassword.editText?.setError("Fill  Password")


            }

            else if(binding.editPassword.editText?.text.toString().isEmpty()){
                binding.editPassword.editText?.setError("Fill  Password")
            }
           else {

                CoroutineScope(Dispatchers.Main).launch {
                    val email = binding.editEmail.editText?.text.toString()
                    val password = binding.editPassword.editText?.text.toString()
                    if (viewmodel.getdata(email, password)) {
                        startActivity(Intent(this@Login_Activity, Userdetails::class.java))
                    } else {
                        Toast.makeText(
                            this@Login_Activity,
                            "Please fill valid value ",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }


        }





    }
    fun SignUp(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }


//    private fun showtoast() {
//        Toast.makeText(this@Login_Activity, "Please fill valid value ", Toast.LENGTH_SHORT).show()
//    }

//    private fun launchactivity() {
//        startActivity(Intent(this@Login_Activity, Userdetails::class.java))
//    }

}