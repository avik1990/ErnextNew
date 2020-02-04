package com.app.ernext.others

interface BaseView<T> {

    fun goToNextPage()
    fun isFragmentAlive():Boolean
    fun isActivityRunning(): Boolean
    fun setPresenter(presenter: T)
    fun isNetworkAvailable():Boolean
    fun showNetworkUnavailableMsg()
    fun showSomeErrorOccurredMsg(msg:String)

}