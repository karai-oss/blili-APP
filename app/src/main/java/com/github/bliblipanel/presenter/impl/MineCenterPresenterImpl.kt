package com.github.bliblipanel.presenter.impl

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.github.bliblipanel.model.MineCenterModel
import com.github.bliblipanel.presenter.IMineCenterPresenter
import com.github.bliblipanel.view.IMineCenterView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MineCenterPresenterImpl(var IMineCenterModel : MineCenterModel ,


                              var mContext : Context?) : IMineCenterPresenter {
     override fun loadingGongGaoData(callBack :  IMineCenterView) {



        GlobalScope.launch {
            mContext?.let {
                IMineCenterModel.GetMineCenterGongGaoData(it)?.let {
                    it.data?.let {
                        callBack.GongGaoCallBack(it)
                    }.let {

                        callBack.loadDataError("公告数据获取失败")

                    }

                }
            }
        }



    }
}