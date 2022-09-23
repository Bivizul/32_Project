package aaa.bivizul.a32project.virbetwdg

import aaa.bivizul.a32project.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage

@Composable
actual fun VirbetItemImage(model: String) {
    AsyncImage(
        model = model,
        contentDescription = stringResource(R.string.image_virbet_item),
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop,
    )

}