package com.github.bliblipanel.ui.page.Home.Mine

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.github.bliblipanel.Base.APP_STORAGE_NAME
import com.github.bliblipanel.Base.FANG_SONG
import com.github.bliblipanel.Base.USER_COVER
import com.github.bliblipanel.Base.USER_NAME
import com.github.bliblipanel.Base.getStorage
import com.github.bliblipanel.R
import com.github.bliblipanel.model.MineCenterModel
import com.github.bliblipanel.presenter.impl.MineCenterPresenterImpl
import com.github.bliblipanel.ui.theme.primaryColor
import com.github.bliblipanel.view.IMineCenterView
import kotlin.math.min

class MineCenterPage : IMineCenterView {

    private var mContext: Context? = null

    private var mAtivity: Activity? = null;
    var sharedPreferences: SharedPreferences? = null;

    private var mineCenterPresenter: MineCenterPresenterImpl? = null;
    var gongGaoData by mutableStateOf("")

    constructor(
        mContext: Context? = null,
        mAtivity: Activity? = null,
    ) {
        this.mContext = mContext;
        this.mAtivity = mAtivity;
        this.sharedPreferences = mContext?.let {
            it.getSharedPreferences(APP_STORAGE_NAME, Context.MODE_PRIVATE)
        } ?: TODO("mContext is null")

        mineCenterPresenter = MineCenterPresenterImpl(
            MineCenterModel(), mContext
        )

    }


    @Composable
    override fun Screen() {
        val window = (LocalView.current.context as Activity).window
        window.statusBarColor = Color.White.copy(0f).toArgb()
        window.decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE



        mineCenterPresenter?.let {
            it.loadingGongGaoData(object : IMineCenterView {
                override fun GongGaoCallBack(GongGao: String) {
                    super.GongGaoCallBack(GongGao)
                    gongGaoData = GongGao
                    return
                }

                override fun loadDataError(message: String) {

                    this@MineCenterPage.mAtivity?.let {


                    }
                }
            })
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
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
                            it.getString(
                                USER_COVER,
                                "https://cdn.pixabay.com/photo/2016/07/19/04/40/moon-1527501_1280.jpg"
                            )
                        }),
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
            Column(
                modifier = Modifier
                    .absoluteOffset(x = 20.dp, y = 20.dp)
                    .width(LocalConfiguration.current.screenWidthDp.minus(40).dp)
                    .height(250.dp)
                    .background(Color.White)
                    .padding(10.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                            .width(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(0.4f))
                    )
                    Text(
                        text = "我的公告",
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        color = Color.Gray.copy(0.3f),
                        fontFamily = FANG_SONG,
                        modifier = Modifier.offset(x = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = gongGaoData,
                    fontSize = TextUnit(16f, TextUnitType.Sp),
                    color = Color.Gray.copy(0.5f),
                    fontFamily = FANG_SONG,

                )
            }

            /**
             * 退出登录
             */
            OutlinedButton(
                shape = RectangleShape,
                border = null,

                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = primaryColor,
                    containerColor = primaryColor.copy(0.3f)
                ),
                modifier = Modifier
                    .width(300.dp)
                    .offset(y = LocalConfiguration.current.screenHeightDp.minus(630).dp)
                    .align(Alignment.CenterHorizontally),
                onClick = {
                         mineCenterPresenter.let {
                             it?.let {
                                 val storage =
                                     it.IMineCenterModel.getStorage(this@MineCenterPage.mContext!!)
                                 storage.edit().clear().apply();
                                 this@MineCenterPage.mAtivity?.finish()
                             }
                         }
                }, contentPadding = PaddingValues(horizontal = 10.dp)
            ) {
                Text(text = "退出登录", textAlign = TextAlign.Center)
            }
        }
    }


}

@Preview(showBackground = true, device = "id:pixel_2_xl")
@Composable
fun Show() {
    MineCenterPage(LocalContext.current).Screen()
}

