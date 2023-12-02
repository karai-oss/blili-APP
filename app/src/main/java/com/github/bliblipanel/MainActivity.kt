package com.github.bliblipanel

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.content.edit
import androidx.core.view.WindowCompat
import com.github.bliblipanel.Base.APP_STORAGE_NAME
import com.github.bliblipanel.Base.Home_PAGE
import com.github.bliblipanel.Base.IBaseModel
import com.github.bliblipanel.Base.KEY_IS_LOGIN
import com.github.bliblipanel.Base.PAGE_GUIDE
import com.github.bliblipanel.Base.PAGE_MID
import com.github.bliblipanel.Base.PAGE_SESSIONDATA
import com.github.bliblipanel.ui.page.GuildePage.GuidePage
import com.github.bliblipanel.ui.page.GuildePage.MIDPage
import com.github.bliblipanel.ui.page.GuildePage.SessionDataPage
import com.github.bliblipanel.ui.page.Home.Home
import com.github.bliblipanel.ui.theme.BliBliPanelTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var sharedPreferences = getSharedPreferences(APP_STORAGE_NAME, MODE_PRIVATE)
        setContent {
            BliBliPanelTheme(
                darkTheme = false
            ) {

                rememberSystemUiController().setStatusBarColor(
                    Color.Transparent , darkIcons = true
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    var pageName : String by remember {
                        mutableStateOf(PAGE_GUIDE)
                    }

                    if (sharedPreferences.getBoolean(KEY_IS_LOGIN , false)){
                        Home(this@MainActivity).startView(this@MainActivity)
                    }else {
                        if (pageName.equals(PAGE_GUIDE) ){

                            GuidePage()
                                .GuidePage{
                                    pageName = it
                                    Log.e("TAG", "onCreate: "+pageName )
                                }
                        } else if (pageName.equals(PAGE_MID)   ){
                            MIDPage(this@MainActivity)
                                .MID_Page{
                                    pageName = it
                                }
                        }else if (pageName.equals(PAGE_SESSIONDATA)){
                            SessionDataPage(this@MainActivity).sessionDataPage{
                                pageName = it
                                sharedPreferences
                                    .edit {
                                        putBoolean(KEY_IS_LOGIN , true)
                                            .apply();
                                    }
                            }
                        }else if (pageName.equals(Home_PAGE)){
                            Home(this@MainActivity).startView(this@MainActivity)
                        }
                    }


                }
            }


        }
    }



}

