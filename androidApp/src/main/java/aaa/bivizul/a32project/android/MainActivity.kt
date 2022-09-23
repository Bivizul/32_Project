package aaa.bivizul.a32project.android

import aaa.bivizul.a32project.virbetscreen.VirbetSetContent
import aaa.bivizul.a32project.virbetscreen.virbetroot.VirbetRootComponent
import aaa.bivizul.a32project.virbetutil.checkVirbetnet
import aaa.bivizul.a32project.virbetutil.getVirbetdlg
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
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

//        primary = Color(0xFFA30000),
//        onPrimary = Color.Black,
//        secondary = Color(0xFF00FFC4),
//        surface = Color(0x9500FFC4)

    }
}
