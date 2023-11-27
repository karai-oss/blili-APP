package com.github.bliblipanel.presenter

interface IHomePresenter {


    fun  initUserInfo(mid : String? ,sessionData : String?)
    fun initNoticeData(string: String?, string1: String?)
    abstract fun initFenData(mid: String?, sessionData: String?)
}