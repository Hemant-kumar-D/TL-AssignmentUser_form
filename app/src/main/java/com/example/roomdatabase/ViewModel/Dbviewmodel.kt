package com.example.roomdatabase.ViewModel

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.Repojetry.DbRepojetry
import com.example.roomdatabase.RoomDB.Student
import com.example.roomdatabase.obserbal.fieldobservebal

class Dbviewmodel(private val repogetry:DbRepojetry):ViewModel(){
    var errormess:MutableLiveData<String> = MutableLiveData()
    var nameerror:MutableLiveData<String> = MutableLiveData()
   var Passworderr:MutableLiveData<String> = MutableLiveData()
    var Emailerr:MutableLiveData<String> = MutableLiveData()
    var Conforerror :MutableLiveData<String> = MutableLiveData()
    var mobile :MutableLiveData<String> = MutableLiveData()
    var baserver:fieldobservebal=fieldobservebal()
//    suspend fun insertdata(student: Student){
//        repogetry.insersdata(student)
//    }
    // new
    suspend fun getdata(email:String,password:String):Boolean{
        return repogetry.getdata(email,password)
    }
    suspend fun submitragistration(student: Student){
//        if(baserver.name.isEmpty()&&baserver.email.isEmpty()&&baserver.mobile.isEmpty()&&baserver.password.isEmpty()
//            &&baserver.confermpass.isEmpty()){
//            errormess.value="please fill all field"
//        }
         if(baserver.name.isEmpty()){
            nameerror.value="please fillname"
        }
        else if (baserver.email.isEmpty()&&!Patterns.EMAIL_ADDRESS.matcher(baserver.email).matches()){
            Emailerr.value="Please Fill right mail"
        }
         else if(baserver.mobile.isEmpty()){
             mobile.value="Please fill mobile number"
         }
        else if(baserver.mobile.length>10&&baserver.mobile.length<9){
            mobile.value="Please fill Right number"

        }
        else if(baserver.password.isEmpty()){
               Passworderr.value="Please fill password field"
         }

        else if(baserver.password.length>=8&&baserver.password.length<=16){

            Passworderr.value="please fill "
        }
         else if(baserver.password.isEmpty()){
             Conforerror.value="Please fill password field"
         }

         else if(baserver.password.length>=8&&baserver.password.length<=16){

             Conforerror.value="please fill "
         }
        else if(!baserver.password.equals(baserver.confermpass)){
            Conforerror.value="password does not match"
         }
        else{
            repogetry.insersdata(student)
         }

}
}