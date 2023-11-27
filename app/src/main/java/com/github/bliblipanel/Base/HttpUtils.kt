package com.github.bliblipanel.Base

import android.util.Log
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.http2.Header
import kotlin.math.log


var client = OkHttpClient();

const val HOST = "https://api.bilibili.com/x"


fun  getRequestExetucor (url:String , session :String) : Call   {
    var getRequest: Request = Request.Builder()
        .url(
            HOST + url
        )
        .get()
        .addHeader("Cookie" ,
            "SESSDATA=$session")
        .addHeader("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
        .build()

    return  client.newCall(getRequest);
}


suspend fun initUserInfo(
    url : String ,
    session : String,
    clazz: Class<*>
) : Any?{

    val userInfoJson = getRequestExetucor(url, session).execute()

    if (userInfoJson.code === 200) {
        return Gson().fromJson(userInfoJson.body?.let {
           it.string()
        } ,clazz)
    }
    return null;
}

suspend fun initNoticeData(
    url : String ,
    session : String,
    clazz: Class<*>
):Any?{
    val userInfoJson = getRequestExetucor(url, session).execute()

    if (userInfoJson.code === 200) {
        return Gson().fromJson(userInfoJson.body?.let {
            it.string()
        } ,clazz)
    }
    return null;
}

suspend fun initFenData(
    url : String ,
    session : String,
    clazz: Class<*>
):Any?{
    val fenJson = getRequestExetucor(url, session).execute()

    if (fenJson.code === 200) {
        return Gson().fromJson(fenJson.body?.let {
            it.string()
        } ,clazz)
    }else{
        return 0;
    }
    return null;
}






