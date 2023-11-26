package com.github.bliblipanel.Base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.github.bliblipanel.MainActivity


/**
 * 标识View接口
 */
interface IBaseView {

}


/**
 * 标识model接口
 */
interface IBaseModel{

}

/**
 * 标识 presenter 接口
 */
interface IBasePresenter {

}


fun IBaseModel.getStorage( context: Context ) : SharedPreferences {

    return context.getSharedPreferences(APP_STORAGE_NAME , ComponentActivity.MODE_PRIVATE);
}
