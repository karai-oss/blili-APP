package com.github.bliblipanel.ui.page.Home.HomePage

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.github.bliblipanel.Base.APP_STORAGE_NAME
import com.github.bliblipanel.Base.FANG_SONG
import com.github.bliblipanel.Base.KEY_MID_STORAGE
import com.github.bliblipanel.Base.KEY_SESSION_DATA
import com.github.bliblipanel.R
import com.github.bliblipanel.model.HomePageModel
import com.github.bliblipanel.model.domain.Item
import com.github.bliblipanel.model.domain.UserListItem
import com.github.bliblipanel.presenter.impl.HomePresenter
import com.github.bliblipanel.ui.theme.NOTICE_COLOR
import com.github.bliblipanel.ui.theme.USER_TEXT_COLOR
import com.github.bliblipanel.ui.theme.USER_TEXT_LOGIN_TIME
import com.github.bliblipanel.view.IHomePageView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


/**
 * Home page
 */


class HomePage(var mContext: Context?) : IHomePageView {

    var username = mutableStateOf("")
    var cover = mutableStateOf("")
    var noticeMessageList = mutableStateOf(listOf<Item>())

    constructor() : this(null)

    val homePagePresenter by lazy {
        HomePresenter(this, HomePageModel());
    }

    @SuppressLint("SuspiciousIndentation")
    @Preview()
    @Composable
    fun HomeView(

    ) {

        // page 滑动
        val scrollstate = rememberScrollState()
        var sharedPreferences = mContext?.let {
            it.getSharedPreferences(APP_STORAGE_NAME, Context.MODE_PRIVATE)
        } ?: TODO("mContext is null")
        // 初始化用户数据
        homePagePresenter.initUserInfo(
            sharedPreferences.getString(KEY_MID_STORAGE, ""),
            sharedPreferences.getString(KEY_SESSION_DATA, "")
        )

        // 初始化 公告数据
        homePagePresenter.initNoticeData(
            sharedPreferences.getString(KEY_MID_STORAGE, ""),
            sharedPreferences.getString(KEY_SESSION_DATA, "")
        )

        // 初始化粉丝数据


        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0x9703A7FE),
                                Color(0xFFF)
                            ),
                        )
                    )
            ) {
                UserInfoPanel(
                    modifier = Modifier
                        .offset(x = 10.dp, y = 40.dp)
                );
                Column(
                    modifier = Modifier.
                    fillMaxHeight()
                        .verticalScroll(scrollstate)
                ) {
                    Row(
                        modifier = Modifier.offset(y = 100.dp)
                    ) {
                        Spacer(modifier = Modifier.width(10.dp))
                        DataPanel(
                            panelName = "粉丝数据",
                            panelTitleColor = USER_TEXT_COLOR,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        DataPanel(
                            panelName = "通知公告",
                            panelTitleColor = NOTICE_COLOR,
                            modifier = Modifier.weight(1f),
                            items = noticeMessageList.value
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }

            }
        }

    }

    @Composable
    fun UserInfoPanel(
        modifier: Modifier = Modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .then(modifier),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(25.dp)),
                painter = rememberAsyncImagePainter(model = cover.value),

                contentDescription = ""
            )


            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = username.value,
                    color = USER_TEXT_COLOR,
                    fontFamily = FANG_SONG,
                    fontSize = TextUnit(20f, TextUnitType.Sp)
                );
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "登录时间：${
                        LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        )
                    }",
                    color = USER_TEXT_LOGIN_TIME,
                    fontFamily = FontFamily(
                        fonts = listOf(Font(R.font.songti))
                    ),
                    fontSize = TextUnit(15f, TextUnitType.Sp)
                );

            }


        }
    }

    override fun ShowLoadingView() {

    }

    // 获取通知公告
    override fun earnNoticeMessage(message: List<Item>) {
        Log.e("TAG", "earnNoticeMessage: $message")
        noticeMessageList.value = message;
    }

    // 初始化用户信息
    override fun initUserInfoSuccess(username: String, cover: String) {
        this.username.value = username;
        this.cover.value = cover
    }

    //获取粉丝相关数据
    override fun getFenListSuccess(list: List<UserListItem>) {
        TODO("Not yet implemented")
    }


    override fun distoryLoadingView() {

    }
}

/**
 * 数据面板
 */
@Composable
fun DataPanel(
    isNotice: Boolean = false,
    panelName: String = "",
    panelTitleColor: Color = Color.Green,
    items: List<Item> = listOf<Item>(),
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)

            .then(modifier)
    ) {


        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row {
                Spacer(
                    modifier = Modifier
                        .width(15.dp)
                        .height(15.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(panelTitleColor.copy(alpha = 0.3f))
                )

                Text(
                    text = panelName, fontFamily = FANG_SONG,
                    color = panelTitleColor,
                    fontSize = TextUnit(10f, TextUnitType.Sp),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if (items == null || items.isEmpty())

                Log.e("TAG", "DataPanel: 暂无信息 ")
            else
                LazyColumn(
                    content = {
                        items(if (items.size >= 15) items.subList(0 , 10).size else 10  ) {
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = (it+1).toString()+"."+items[it].item.source_content,
                                color = panelTitleColor,
                                fontSize = TextUnit(10f, TextUnitType.Sp),
                            );
                        }
                    })
        }

    }

}


/**
 * 粉丝记录面板
 */

@Preview(showBackground = true)
@Composable
fun FenPanel(){
    Column(
        modifier = Modifier
            .height(240.dp)
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp),

    ) {
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart,
        ) {

            // 粉丝头像
            Image(
                painter = painterResource(id = R.drawable.home_select),
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(25.dp)),
                contentDescription = "粉丝图片"
            )
            // 上行中间
            Column(
                modifier = Modifier.absoluteOffset(x = 70.dp)
            ) {
                Text(
                    text = "用户名称",
                    fontFamily = FANG_SONG,
                    fontSize = TextUnit(15f, TextUnitType.Sp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "用户名称",
                    fontFamily = FANG_SONG,
                    color = Color(0xFFE4E4E4),
                    fontSize = TextUnit(10f, TextUnitType.Sp)
                )
            }


            // 日期
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.date),
                    modifier = Modifier.size(20.dp),
                    contentDescription = "时间"
                )
                Text(
                    text = "2022年10月11日",
                    fontFamily = FANG_SONG,
                    color = USER_TEXT_COLOR,
                    fontSize = TextUnit(10f, TextUnitType.Sp)
                )

            }
        }




        // 粉丝的作品列表
    }
}
