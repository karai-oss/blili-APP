package com.github.bliblipanel.presenter

interface IMidPresenter {

    fun enterNextSessionDataSettings();

    fun joinAppStorage(mid : String) : Boolean;
}