package com.github.bliblipanel.ui.page.Home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.bliblipanel.R
import com.github.bliblipanel.ui.page.Home.HomePage.HomePage


/**
 * Home app 主界面
 */
class Home(var mContext : Context) {



    @Composable
    fun startView(){

        Column(
            Modifier.fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(LocalConfiguration.current.screenHeightDp.minus(60).dp)) {


                HomePage(mContext).HomeView()


            }

            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier.height(60.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.home_select),
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        contentDescription = ""
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        painter = painterResource(id = R.drawable.mine_no_select),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}