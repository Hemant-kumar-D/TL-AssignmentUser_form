package com.example.roomdatabase

import android.app.ActionBar
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.roomdatabase.Factory.Dbfactroy
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.RoomDB.DataBaseStudent
import com.example.roomdatabase.RoomDB.Student
import com.example.roomdatabase.View_Model.Dbviewmodel
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.example.roomdatabase.databinding.LayoutcustombindingBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    lateinit var Factory: Dbfactroy
    lateinit var viewmodel: Dbviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Factory = Dbfactroy(DbRepojetry(DataBaseStudent.myobjct(this).studentdao()))
        viewmodel = ViewModelProvider(this, Factory)[Dbviewmodel::class.java]
        binding.recycylerviewview.layoutManager = GridLayoutManager(this, 2)
        binding.btnCreateData.setOnClickListener(this)
    }

    override fun onClick(v: View?) {


        val layoutCustomBinding = LayoutcustombindingBinding.inflate(layoutInflater)
        val dialog = Dialog(this)

        dialog.setContentView(layoutCustomBinding.root)
        dialog.setCancelable(false)
        val windowManager = WindowManager.LayoutParams()
        windowManager.width = ActionBar.LayoutParams.MATCH_PARENT
        windowManager.height = ActionBar.LayoutParams.WRAP_CONTENT
        dialog.window?.attributes = windowManager
        dialog.show()


        layoutCustomBinding.btnSubmit.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewmodel.insertdata(
                    Student(
                        1,
                        layoutCustomBinding.tilFname.editText?.text.toString(),
                        layoutCustomBinding.tilLname.editText?.text.toString(),
                        layoutCustomBinding.tilPhone.editText?.text.toString()
                    )
                )

                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Inserted Succefully.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            dialog.dismiss()
        }
    }
}


