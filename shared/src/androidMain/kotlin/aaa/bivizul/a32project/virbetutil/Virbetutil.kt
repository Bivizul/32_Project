@file:Suppress("DEPRECATION")

package aaa.bivizul.a32project.virbetutil

import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETACT
import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETKOR
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.telephony.TelephonyManager
import androidx.browser.customtabs.CustomTabsIntent
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

actual val virbetUiDispatcher: CoroutineContext = Dispatchers.Main

actual val virbetIoDispatcher: CoroutineContext = Dispatchers.IO

actual fun getVirbetmm(): String {
    val manfacvirbet = android.os.Build.MANUFACTURER
    val modelvirbet = android.os.Build.MODEL
    return "$manfacvirbet $modelvirbet"
}

actual fun getVirbetsim(virbetcon: Any): String {
    val context = virbetcon as Context
    val telmanvirbet = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanvirbet.simCountryIso
}

actual fun getVirbetid(virbetcon: Any): String {
    val context = virbetcon as Context
    val sharedPreferences = context.getSharedPreferences("appprefvirbet", Context.MODE_PRIVATE)
    var virbetid = sharedPreferences.getString("virbet_key", "novirbet") ?: "novirbet"
    if (virbetid == "novirbet") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        virbetid = datetime + randomNum
        sharedPreferences.edit().putString("virbet_key", virbetid).apply()
    }
    return virbetid
}

actual fun getVirbetl(): String {
    return Locale.getDefault().language
}

actual fun getVirbett(): String {
    val virbettz = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var virbetzone = "00:00"
    if (virbettz.length > 3) {
        virbetzone = virbettz.substring(3)
    }
    return virbetzone
}

actual fun getVirbetdlg(virbetcon: Any) {
    val context = virbetcon as Context
    val activity = virbetcon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Sorry,an error occurred ")
        setMessage("Please try again later")
        setPositiveButton("Quit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkVirbetnet(virbetcon: Any): Boolean {
    val context = virbetcon as Context
    val conmanvirbet =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfvirbet = conmanvirbet.activeNetworkInfo
    return netinfvirbet != null && netinfvirbet.isConnected
}

actual fun sigVirbetoff() {
    OneSignal.disablePush(true)
}

//actual fun virbetct(virbetcon: Any, virbetcc: String) {
//    val context = virbetcon as Context
//    val package_name = "com.android.chrome"
//    val activity = (context as? Activity)
//    val virbetctbuilder = CustomTabsIntent.Builder()
//        .setShowTitle(false)
//        .setInstantAppsEnabled(true)
//        .build()
//    if (package_name != null) {
//        virbetctbuilder.intent.setPackage(package_name)
//        virbetctbuilder.launchUrl(context, Uri.parse(virbetcc))
//    } else {
//        val virbeti = Intent(Intent.ACTION_VIEW, Uri.parse(virbetcc))
//        activity?.startActivity(virbeti)
//    }
//}

//internal actual fun getVirbetactoff(virbetcon: Any) {
//    val activity = virbetcon as Activity
//    activity.finish()
//    System.exit(0)
//}

actual fun getVirbetact(virbetact: Any, virbeturl: String) {
    val activity = virbetact as Activity
    val a = Class.forName(VIRBETACT)
    val intent = Intent(activity, a)
    val put = intent.putExtra(VIRBETKOR, virbeturl)
    activity.startActivity(put)
}