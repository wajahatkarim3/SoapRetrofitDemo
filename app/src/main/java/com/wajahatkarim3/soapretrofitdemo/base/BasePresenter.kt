package com.wajahatkarim3.soapretrofitdemo.base

import android.support.annotation.CallSuper

open class BasePresenter<T>(view: T) {

    var _view: T? = view

    @CallSuper
    fun attachView(view: T)
    {
        _view = view
    }

    @CallSuper
    fun detachView()
    {
        _view = null
    }

    fun isViewAttached() : Boolean = _view != null
}