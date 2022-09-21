package aaa.bivizul.a32project.virbetwdg

import aaa.bivizul.a32project.virbetutil.Virbetcon
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
actual fun Virbetibl() {

    val virbetorient = LocalConfiguration.current.orientation
    val virbetImgUrl = when (virbetorient) {
        Configuration.ORIENTATION_PORTRAIT -> Virbetcon.VIRBETBV
        else -> Virbetcon.VIRBETBH
    }

//    FrescoImage(
//        imageUrl = virbetImgUrl,
//        imageOptions = ImageOptions(
//            contentScale = ContentScale.Crop,
//            alignment = Alignment.Center
//        )
//    )

}