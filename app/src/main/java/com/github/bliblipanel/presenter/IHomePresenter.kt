package com.github.bliblipanel.presenter

import androidx.compose.runtime.Composable
import com.github.bliblipanel.model.domain.VideoItem

interface IHomePresenter {


    fun  initUserInfo(mid : String? ,sessionData : String?)
    fun initNoticeData(string: String?, string1: String?)
    abstract fun initFenData(mid: String?, sessionData: String?)


    fun initVideoList (mid : String? ,sessionData: String? , callback :  (list: List<VideoItem>)->Unit);
}