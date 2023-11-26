package com.github.bliblipanel.model

import android.util.Log
import com.github.bliblipanel.Base.getRequestExetucor
import com.github.bliblipanel.model.domain.ReplyNoticeData

import com.github.bliblipanel.model.domain.UserInfoWrapperDoMain
import okhttp3.Call
import okhttp3.Response


/**
 * HOME PAGE MODEL
 */
class HomePageModel {
    suspend fun initUserInfo(url: String, sessionData: String): UserInfoWrapperDoMain? {
       return  com.github.bliblipanel.Base.initUserInfo(url = url , session = sessionData ,
           UserInfoWrapperDoMain::class.java) as UserInfoWrapperDoMain
    }

    suspend fun initNoticeData(url: String, sessionData: String) : ReplyNoticeData {
        return  com.github.bliblipanel.Base.initNoticeData(url = url , session = sessionData,
            ReplyNoticeData::class.java) as ReplyNoticeData
    }


}