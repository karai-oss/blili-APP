package com.github.bliblipanel.model

import android.util.Log
import com.github.bliblipanel.Base.getRequestExetucor
import com.github.bliblipanel.model.domain.ReplyNoticeData
import com.github.bliblipanel.model.domain.UserFenData
import com.github.bliblipanel.model.domain.UserFenModel

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


    suspend fun initFenData(url: String, sessionData: String) : UserFenModel? {

        val result = com.github.bliblipanel.Base.initFenData(
            url = url, session = sessionData,
            UserFenModel::class.java
        )

        Log.e("TAG", "initFenData11: $result" )

        if (result == 0)
            return null;
        else
            return result as UserFenModel
    }

    suspend fun getFenVideoList(url : String ,sessionData : String){

    }
}