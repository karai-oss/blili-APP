package com.github.bliblipanel.view

import android.content.Context
import androidx.compose.runtime.Composable

interface IMineCenterView : IView{



      @Composable
       override fun Screen() {

       }

      fun GongGaoCallBack (GongGao : String){}

    fun loadDataError(message : String){};


}

