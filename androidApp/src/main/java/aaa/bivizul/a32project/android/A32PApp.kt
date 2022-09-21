package aaa.bivizul.a32project.android

import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETOSAI
import android.app.Application
import com.onesignal.OneSignal

class A32PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(VIRBETOSAI)

    }
}