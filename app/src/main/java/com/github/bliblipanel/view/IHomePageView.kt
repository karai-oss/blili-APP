package com.github.bliblipanel.view

import com.github.bliblipanel.model.domain.ReplyItem
import com.github.bliblipanel.model.domain.UserListItem
import com.github.bliblipanel.model.domain.VideoItem

interface IHomePageView :IView {

    fun ShowLoadingView();


    // 获取通知公告 也就是消息
    fun earnNoticeMessage(message: List<ReplyItem>)

    // 初始化home界面的 用户信息
    fun initUserInfoSuccess( username : String ,  cover : String);


    // 获取粉丝的信息
    fun getFenListSuccess(list: List<UserListItem>);



    fun distoryLoadingView();
}