package com.github.bliblipanel.Base

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.github.bliblipanel.R


// 字体相关数据
val FANG_SONG = FontFamily(
    fonts = listOf(Font(R.font.songti))
)

const val PAGE_GUIDE = "guide"
const val PAGE_MID = "MID"
const val PAGE_SESSIONDATA = "sessiondata"
const val Home_PAGE = "HOME"

const val APP_STORAGE_NAME = "blbl"

var MAIN_CONTEXT : Context? = null;


// mid
const val KEY_MID_STORAGE = "mid"

// session data ;

const val KEY_SESSION_DATA ="session data";


const val KEY_IS_LOGIN = "IS_LOGIN"


