package com.github.bliblipanel.ui.page.Home.Mine

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import coil.compose.rememberAsyncImagePainter
import com.github.bliblipanel.Base.APP_STORAGE_NAME
import com.github.bliblipanel.Base.USER_COVER
import com.github.bliblipanel.Base.USER_NAME
import com.github.bliblipanel.R
import com.github.bliblipanel.ui.theme.primaryColor
import com.github.bliblipanel.view.IMineCenterView

class MineCenterPage : IMineCenterView {

    private var mContext: Context? = null
    var sharedPreferences: SharedPreferences? = null;


    constructor(
        mContext: Context? = null,
    ) {
        this.mContext = mContext;
        this.sharedPreferences = mContext?.let {
            it.getSharedPreferences(APP_STORAGE_NAME, Context.MODE_PRIVATE)
        } ?: TODO("mContext is null")
        // 加载数据
        this.loadData(mContext)
    }

    // 记载数据
    override fun loadData(mContext: Context?) {

    }

    @Composable
    override fun Screen() {
        val window = (LocalView.current.context as Activity).window
        window.statusBarColor = Color.White.copy(0f).toArgb()
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.Center

            ) {
                Image(
                    painter = painterResource(id = R.drawable.bg),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "背景图片",
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.6f)
                        .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                )

                Column(
                    Modifier.wrapContentSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                            .padding(2.dp),
                        painter = rememberAsyncImagePainter(model = sharedPreferences?.let {
                            it.getString(USER_COVER , "https://cdn.pixabay.com/photo/2016/07/19/04/40/moon-1527501_1280.jpg")
                        }) ,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "用户头像"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = sharedPreferences?.let {
                            it.getString(USER_NAME, "匿名用户")
                        }.toString(),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                    )
                }

            }
            /**
             * 相关消息面板
             */



            /**
             * 退出登录
             */
            OutlinedButton(
                shape = RectangleShape,
                border = null,

                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = primaryColor ,
                    containerColor = primaryColor.copy(0.3f)
                ),
                modifier = Modifier
                    .width(300.dp)
                    .offset(y = LocalConfiguration.current.screenHeightDp.minus(340).dp)
                    .align(Alignment.CenterHorizontally),
                onClick = {

            } , contentPadding = PaddingValues(horizontal = 10.dp)) {
                Text(text = "退出登录" , textAlign = TextAlign.Center)
            }
        }
    }
}