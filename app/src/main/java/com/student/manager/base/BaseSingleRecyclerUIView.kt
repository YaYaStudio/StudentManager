package com.student.manager.base

/**
 * Created by angcyo on 2018/02/13 23:11
 */
abstract class BaseSingleRecyclerUIView<T> : BaseRecyclerUIView<String, T, String>() {

    override fun isUIHaveLoadMore(datas: MutableList<T>?): Boolean {
        return false
    }
}
