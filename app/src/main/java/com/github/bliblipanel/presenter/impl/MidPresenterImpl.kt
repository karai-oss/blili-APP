package com.github.bliblipanel.presenter.impl

import android.util.Log
import android.widget.Toast
import com.github.bliblipanel.model.MidModel
import com.github.bliblipanel.presenter.IMidPresenter
import com.github.bliblipanel.view.IMidView

class MidPresenterImpl(midView : IMidView , var midModel : MidModel) : IMidPresenter {




    override fun enterNextSessionDataSettings() {
        TODO("Not yet implemented")
    }

    override fun joinAppStorage(mid: String) : Boolean {
       if (mid == null || mid.isEmpty() || mid == ""){
           Log.e("TAG", "mid 不能为空 " )
           Toast.makeText(midModel.mContext , "mid不能为空" , Toast.LENGTH_SHORT).show();
           return false
       }
        midModel.joinStorage(mid);
        return true
    }
}