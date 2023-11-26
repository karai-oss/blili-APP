package com.github.bliblipanel.ui.page.GuildePage

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.github.bliblipanel.Base.PAGE_MID
import com.github.bliblipanel.R


class GuidePage {



    @SuppressLint("NotConstructor")
    @Composable
    fun GuidePage(to : (target_page : String) -> Unit) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.blbl),
                modifier = Modifier
                    .width(190.dp)
                    .height(141.dp)
                    .align(Alignment.CenterHorizontally)
                    .offset(y = 100.dp),
                contentDescription = ""
            )

            Spacer(
                modifier = Modifier
                    .height(380.dp)
            )

            enter(modifier = Modifier
                .align(Alignment.CenterHorizontally), to = to);
            Row(
                Modifier
                    .fillMaxWidth()
                    .offset(y = 30.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Power By",
                    fontSize = TextUnit(
                        20f,
                        TextUnitType.Sp
                    ),
                    color = Color(0xFFDCDCDC)
                )

                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Mr.Xie",
                    fontSize = TextUnit(
                        20f,
                        TextUnitType.Sp
                    )
                )
            }
        }
    }


    @Composable
    fun enter(modifier: Modifier ,to : (target_page : String) -> Unit ){
        Row(
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
                .background(
                    color = Color(0xFF03A7FE),
                    shape = RoundedCornerShape(45.dp)
                )
                .clickable(indication = null , interactionSource = remember {
                    MutableInteractionSource()
                }){
                    to(PAGE_MID)
                } .then(modifier),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.left),
                contentDescription = ""
            )
        }

    }


}