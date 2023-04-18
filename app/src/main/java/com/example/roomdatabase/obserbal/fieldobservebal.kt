package com.example.roomdatabase.obserbal

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable



class fieldobservebal:BaseObservable() {
  @get:Bindable
  var name:String=""
      set(value) {
        field=value
          //notifyPropertyChanged()
         // notifyPropertyChanged()

    }

    @get:Bindable
    var mobile:String=""
        set(value) {
            field=value
            //notifyPropertyChanged(BR.mobile)
        }
    @get:Bindable
    var email:String=""
        set(value) {
            field=value

        }
    @get:Bindable
    var password:String=""
        set(value) {
            field=value
           // notifyPropertyChanged(BR.password)

           // notifyPropertyChanged(BR.mobile)
        }
    @get:Bindable
    var confermpass:String=""
        set(value) {
            field=value
            //notifyPropertyChanged(BR.confermpass)
                // notifyPropertyChanged(BR)
        }
}