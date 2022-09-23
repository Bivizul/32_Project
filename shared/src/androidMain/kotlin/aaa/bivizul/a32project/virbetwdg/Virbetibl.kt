package aaa.bivizul.a32project.virbetwdg

import aaa.bivizul.a32project.R
import aaa.bivizul.a32project.virbetutil.Virbetcon
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage

@Composable
actual fun Virbetibl() {

    val virbetorient = LocalConfiguration.current.orientation
    val virbetImgModel = when (virbetorient) {
        Configuration.ORIENTATION_PORTRAIT -> Virbetcon.VIRBETBV
        else -> Virbetcon.VIRBETBH
    }

    AsyncImage(
        model = virbetImgModel,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )

}