@file:Suppress("DEPRECATION")

package aaa.bivizul.a32project.android

import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETDOR
import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETKOR
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.*
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import im.delight.android.webview.AdvancedWebView

class VirbetActivity : ComponentActivity(), AdvancedWebView.Listener {

    lateinit var virbetwv: AdvancedWebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_virbet)

        println("VirbetActivity")

        val url = intent.getStringExtra(VIRBETKOR) ?: VIRBETDOR

        virbetwv = findViewById<View>(R.id.virbetawv) as AdvancedWebView

        virbetwv.webViewClient = WebViewClient()
        virbetwv.webChromeClient = MyChromeClient()

        virbetwv.setListener(this, this)
        virbetwv.setMixedContentAllowed(false)

        setSettings()

        if (savedInstanceState == null) {
            virbetwv.post {
                kotlin.run { virbetwv.loadUrl(url) }
            }
        }

        virbetwv.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                virbetwv.canGoBack()
            ) {
                virbetwv.goBack()
                return@OnKeyListener true
            }
            false
        })

    }

    @SuppressLint("NewApi")
    override fun onResume() {
        super.onResume()
        virbetwv.onResume()
    }

    @SuppressLint("NewApi")
    override fun onPause() {
        virbetwv.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        virbetwv.onDestroy()
        super.onDestroy()
    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        virbetwv.onActivityResult(requestCode, resultCode, intent)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (!virbetwv.onBackPressed()) {
            return
        }
        finishAndRemoveTask()
        System.exit(0)
    }


    override fun onPageStarted(url: String?, favicon: Bitmap?) {}

    override fun onPageFinished(url: String?) {}

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {}

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?,
    ) {
    }

    override fun onExternalPageRequest(url: String?) {}

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val virbetws = virbetwv.settings
        virbetws.javaScriptEnabled = true
        virbetws.loadWithOverviewMode = true
        virbetws.allowFileAccess = true
        virbetws.domStorageEnabled = true
        virbetws.builtInZoomControls = true
        virbetws.displayZoomControls = false
        virbetws.useWideViewPort = true
        virbetws.setSupportZoom(true)
        virbetws.setCacheMode(WebSettings.LOAD_NO_CACHE)
        virbetws.userAgentString = virbetws.userAgentString.replace("; wv", "")
    }

    var filePathCallback: ValueCallback<Array<Uri>>? = null
    private val REQUEST_CODE = 100

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        virbetwv.saveState(outState)
    }

    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams,
        ): Boolean {
            filePathCallback = filePath
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(intent, REQUEST_CODE)
            return true
        }

        private var virbetCustomView: View? = null
        private var virbetCustomViewCallback: CustomViewCallback? = null
        private var virbetOriginalOrientation = 0
        private var virbetOriginalSystemUiVisibility = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (virbetCustomView == null) {
                null
            } else BitmapFactory.decodeResource(
                this@VirbetActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@VirbetActivity.window.decorView as FrameLayout).removeView(virbetCustomView)
            virbetCustomView = null
            this@VirbetActivity.window.decorView.systemUiVisibility = virbetOriginalSystemUiVisibility
            this@VirbetActivity.requestedOrientation = virbetOriginalOrientation
            virbetCustomViewCallback!!.onCustomViewHidden()
            virbetCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?,
        ) {
            if (virbetCustomView != null) {
                onHideCustomView()
                return
            }
            virbetCustomView = paramView
            virbetOriginalSystemUiVisibility = this@VirbetActivity.window.decorView.systemUiVisibility
            virbetOriginalOrientation = this@VirbetActivity.requestedOrientation
            virbetCustomViewCallback = paramCustomViewCallback
            (this@VirbetActivity.window.decorView as FrameLayout).addView(
                virbetCustomView,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@VirbetActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

}