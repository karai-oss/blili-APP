package com.github.bliblipanel.ui.page.Home.Mine

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.bliblipanel.view.IMineCenterView

class MineCenterPage : IMineCenterView{

    private var mContext: Context?  = null


    constructor(
         mContext: Context?  = null
    ){
        this.mContext = mContext;
        // 加载数据
        this.loadData(mContext)
    }

    // 记载数据
    override fun loadData(mContext: Context?) {

    }

    @Composable
    override fun Screen() {

        Column {
            Text(text = "个人中心")
        }
    }
}