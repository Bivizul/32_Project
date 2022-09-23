package aaa.bivizul.a32project.virbetscreen

import aaa.bivizul.a32project.virbetscreen.virbetroot.VirbetRootComponent
import aaa.bivizul.a32project.virbetscreen.virbetroot.VirbetRootContent
import aaa.bivizul.a32project.virbettheme.VirbetTheme
import aaa.bivizul.a32project.virbetwdg.Virbetibl
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun VirbetSetContent(
    root: VirbetRootComponent
) {
    VirbetTheme {
        Virbetibl()
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            VirbetRootContent(root)
        }
    }
}