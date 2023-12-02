package com.github.bliblipanel.ui.page.GuildePage

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.clickable
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
import com.github.bliblipanel.Base.PAGE_SESSIONDATA
import com.github.bliblipanel.model.MidModel
import com.github.bliblipanel.presenter.impl.MidPresenterImpl
import com.github.bliblipanel.view.IMidView

/**
 * mid page
 */
class MIDPage(context: Context) : IMidView {


    val midPresenter by lazy {
        MidPresenterImpl(this , MidModel(context));
    }
    @SuppressLint("UnrememberedMutableState")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MID_Page(to : (target : String) -> Unit = {}){

        var mid  by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "请填写MID",
                fontSize = TextUnit(28f, TextUnitType.Sp),
                color = Color(0xFFDEDEDE),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .offset(y = 100.dp),
            )


            Column(
                Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
                    .offset(y = 200.dp)
            ) {

                Text(
                    text = "如何获取mid",
                    Modifier.width(280.dp),
                    textAlign = TextAlign.End
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = mid,

                    placeholder = {
                        Text(
                            text = "mid",
                            color =Color.Gray
                        )
                }, onValueChange = {
                        Log.e("TAG", "MID_Page: "+it )
                            mid =it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                          unfocusedIndicatorColor = Color(0xBC03A7FE),
                          focusedIndicatorColor = Color(0xFF03A7FE),
                        containerColor = Color.White
                    )
                );

                Spacer(modifier = Modifier.height(200.dp))

                GuidePage().enter(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                ){
                    if (midPresenter.joinAppStorage(mid)) {

                        to(PAGE_SESSIONDATA)
                    }
                }
            }
        }
    }

    override fun showSuccess() {
        TODO("Not yet implemented")
    }


}