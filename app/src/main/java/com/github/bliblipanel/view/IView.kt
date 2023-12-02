package com.github.bliblipanel.view

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable

interface IView {

    @Composable
    fun Screen();


    fun toast(message : String , mActivity : Activity){
        mActivity.runOnUiThread{
            Toast.makeText(mActivity ,"公告数据获取失败" , Toast.LENGTH_SHORT).show();
        }

    }
}