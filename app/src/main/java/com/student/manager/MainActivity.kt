package com.student.manager

import android.Manifest
import android.content.Intent
import com.angcyo.uiview.base.UILayoutActivity
import com.orhanobut.hawk.Hawk
import com.student.manager.control.UserControl
import com.student.manager.iview.AdminUIView
import com.student.manager.iview.LoginUIView

class MainActivity : UILayoutActivity() {
    override fun needPermissions(): Array<String> {
        return arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CAMERA)
    }

    override fun onLoadView(intent: Intent?) {
        //startIView(MainUIView(), false)
        checkPermissions()
        if (Hawk.get("AUTO_LOGIN", false)) {
            UserControl.loginUser(Hawk.get("NAME", ""), Hawk.get("PW", "")) {
                if (it == null) {
                    startIView(LoginUIView(), false)
                } else {
                    startIView(AdminUIView(), false)
//                    when (it.type) {
//                        3, 4 -> startIView(AdminUIView(), false)
//                        else -> startIView(MainUIView(), false)
//                    }
                }
            }
        } else {
            startIView(LoginUIView(), false)
        }
    }
}
