package com.github.bliblipanel.model

import android.content.Context
import androidx.core.content.edit
import com.github.bliblipanel.Base.IBaseModel
import com.github.bliblipanel.Base.KEY_MID_STORAGE
import com.github.bliblipanel.Base.getStorage

class MidModel(var mContext: Context) : IBaseModel {

    /**
     * 实现mid 保存操作
     */
    fun joinStorage(mid : String) {
        getStorage(mContext)
            .edit {
                putString(KEY_MID_STORAGE , mid).apply()
            }

    }
}