package com.wajahatkarim3.soapretrofitdemo.screens.home

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.wajahatkarim3.soapretrofitdemo.R
import com.wajahatkarim3.soapretrofitdemo.base.BaseActivity
import com.wajahatkarim3.soapretrofitdemo.databinding.ActivityHomeBinding
import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import sun.bob.mcalendarview.utils.ExpCalendarUtil

class HomeActivity : BaseActivity(), HomeContract.View {

    lateinit var bi: ActivityHomeBinding
    lateinit var presenter: HomePresenter
    lateinit var repository: HomeContract.Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_home)

        repository = HomeRepository(retrofit, this)
        presenter = HomePresenter(this, repository)
        bi.view = this
        bi.presenter = presenter
        presenter.initScreen()
    }

    override fun setupViews() {
        // Calendar
    }

    override fun showLoading(message: String) {
        showProgress(message)
    }

    override fun hideLoading() {
        hideProgress()
    }


}
