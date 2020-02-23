package com.app.ernext.fragments.menus

import com.app.ernext.others.BasePresenter
import com.app.ernext.others.BaseView

interface DealsContract {

    interface Presenter : BasePresenter {
        fun fetchchefdetails()
    }

    interface View: BaseView<Presenter> {
        fun showloader(showingStatus:Boolean) // true --> show, false --> dismiss
        fun hideSearchBar()
    }

}