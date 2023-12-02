package com.github.bliblipanel.model

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import com.github.bliblipanel.Base.IBaseModel
import com.github.bliblipanel.Base.KEY_MID_STORAGE
import com.github.bliblipanel.Base.KEY_SESSION_DATA
import com.github.bliblipanel.Base.getRequest
import com.github.bliblipanel.Base.getStorage
import com.github.bliblipanel.model.domain.GongGaoData


/**
 * 处理个人中心的模型类
 */
class MineCenterModel() : IBaseModel {


    // 通过接口获取个人信息公告数据
     suspend  fun GetMineCenterGongGaoData(context : Context): GongGaoData? {


        val mid = getStorage(context = context).getString(KEY_MID_STORAGE, null)
        val session_data = getStorage(context = context).getString(KEY_SESSION_DATA, null)

        if (mid === null ){
            return null
        }

        if (session_data === null ){
            return null
        }
        val request = getRequest(
            "/space/notice?mid=$mid",
            session_data,
            GongGaoData::class.java
        )?.let {
            it as GongGaoData
        };


        return request?.also { it.data }

    }

}