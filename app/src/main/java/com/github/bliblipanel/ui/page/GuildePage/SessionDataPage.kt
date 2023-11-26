package com.github.bliblipanel.ui.page.GuildePage

import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.github.bliblipanel.Base.APP_STORAGE_NAME
import com.github.bliblipanel.Base.Home_PAGE
import com.github.bliblipanel.Base.KEY_SESSION_DATA
import com.github.bliblipanel.Base.PAGE_SESSIONDATA


/**
 * 设置session data 页面
 */
class SessionDataPage(var mContext : Context ) {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun sessionDataPage(to : (target : String) -> Unit){

        var sessionData by remember {
            mutableStateOf("")
        }
        Column(
            Modifier.fillMaxSize()
        ) {

            Text(
                text = "SEESIONDATA",
                Modifier
                    .fillMaxWidth()
                    .offset(y = 100.dp),
                color = Color(0xFFDEDEDE),
                fontSize = TextUnit(30f , TextUnitType.Sp),
                textAlign = TextAlign.Center
            )

            Column(
                Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
                    .offset(y = 200.dp)
            ) {

                Text(
                    text = "如何获取session data",
                    Modifier.width(280.dp),
                    textAlign = TextAlign.End
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = sessionData,
                    modifier = Modifier.height(200.dp)
                        .width(400.dp),
                    placeholder = {
                        Text(
                            text = "请填写session data",
                            color =Color.Gray
                        )
                    }, onValueChange = {
                        Log.e("TAG", "MID_Page: "+it )
                        sessionData =it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color(0xBC03A7FE),
                        focusedIndicatorColor = Color(0xFF03A7FE),
                        containerColor = Color.White
                    )
                );

                Spacer(modifier = Modifier.height(120.dp))

                GuidePage().enter(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                ){

                    if (sessionData == null || TextUtils.isEmpty(sessionData)){
                        Toast.makeText(this@SessionDataPage.mContext , "session data 不能为空" , Toast.LENGTH_SHORT)
                            .show();
                        return@enter
                    }
                    this@SessionDataPage.mContext.getSharedPreferences(
                        APP_STORAGE_NAME ,
                        Context.MODE_PRIVATE
                    ).edit {

                        putString(KEY_SESSION_DATA ,sessionData)
                            .apply()

                    }
                    to(Home_PAGE)
                }
            }
        }
    }
}