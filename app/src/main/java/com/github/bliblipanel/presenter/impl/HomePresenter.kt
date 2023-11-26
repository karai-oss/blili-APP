package com.github.bliblipanel.presenter.impl

import com.github.bliblipanel.model.HomePageModel
import com.github.bliblipanel.presenter.IHomePresenter
import com.github.bliblipanel.view.IHomePageView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomePresenter(var homePageView : IHomePageView , var homePageModel : HomePageModel) : IHomePresenter {
    override fun initUserInfo(mid: String?, sessionData: String?) {
        if (mid === null || mid.isEmpty()){
            return
        }

        if (sessionData == null || sessionData.isEmpty()){
            return
        }

         GlobalScope.launch {
            val userInfoWrapperDoMain = homePageModel.initUserInfo(
                "/space/wbi/acc/info?mid=$mid",
                sessionData
            )?.let {

                it.data?.let {userdata->
                    userdata.name
                }?.let { it1 ->
                    homePageView.initUserInfoSuccess(
                        it1,
                        it.data.face
                    )
                }
            }


        }
    }

    override fun initNoticeData(mid: String?, sessionData: String?) {
        GlobalScope.launch {
            homePageModel.initNoticeData(
                "/msgfeed/reply" ,
                sessionData!!,
            )?.let {
                it.data?.let {
                    it.items
                }?.let { it1 -> homePageView.earnNoticeMessage(it1) }
            }
        }
    }
}