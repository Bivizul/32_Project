package aaa.bivizul.a32project.android

import aaa.bivizul.a32project.virbetscreen.VirbetSetContent
import aaa.bivizul.a32project.virbetscreen.virbetroot.VirbetRootComponent
import aaa.bivizul.a32project.virbetutil.checkVirbetnet
import aaa.bivizul.a32project.virbetutil.getVirbetdlg
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkVirbetnet(this)) {
            val root = VirbetRootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                VirbetSetContent(root = root)
            }
        } else {
            getVirbetdlg(this)
        }
    }
}
