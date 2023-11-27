package com.github.bliblipanel.ui.page.Home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.bliblipanel.R
import com.github.bliblipanel.ui.page.Home.HomePage.HomePage
import com.github.bliblipanel.ui.page.Home.Mine.MineCenterPage
import com.github.bliblipanel.view.IView


/**
 * Home app 主界面
 */
class Home(var mContext : Context) {



    @Composable
    fun startView(){

        // 页面数据


        var pageList by remember {
            mutableStateOf( mutableListOf(
                Page(0 , true, R.drawable.home_select, R.drawable.home_no_select , HomePage(mContext = mContext)),
                Page(1 ,false, R.drawable.mine_select, R.drawable.mine_no_select , MineCenterPage(mContext = mContext))
            ))
        }


        Column(
            Modifier.fillMaxSize()
        ) {
            val recompose = currentRecomposeScope
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(LocalConfiguration.current.screenHeightDp.minus(60).dp)) {

                pageList.forEach {
                    if (it.selected == true){
                        it.page.Screen();
                    }
                }
            }

            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier.height(60.dp)
            ) {

                pageList.forEach {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(
                            painter = painterResource(id =
                            if (it.selected) it.selectIcon else it.no_selectIcon),
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .clickable(indication = null , interactionSource = remember {
                                    MutableInteractionSource()
                                }) {
                                    pageList.forEach {
                                        it.selected = false
                                    }
                                    pageList[it.index].selected = true
                                    recompose.invalidate();
                                },
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}



data class Page(var index: Int = 0,
                var selected : Boolean = false,
                var selectIcon : Int,
                var no_selectIcon : Int,
    var page : IView);


