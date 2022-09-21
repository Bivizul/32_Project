package aaa.bivizul.a32project.virbetscreen.virbetroot

import aaa.bivizul.a32project.virbetscreen.virbet.VirbetContent
import aaa.bivizul.a32project.virbetscreen.virbethome.VirbetHomeContent
import aaa.bivizul.a32project.virbetscreen.virbetitem.VirbetItemContent
import aaa.bivizul.a32project.virbetscreen.virbetlist.VirbetListContent
import aaa.bivizul.a32project.virbetscreen.virbetsettings.VirbetSettingsContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun VirbetRootContent(virbetRoot: VirbetRoot, modifier: Modifier = Modifier) {

    val childStack by virbetRoot.childStack.subscribeAsState()

    Children(
        stack = childStack,
        modifier = Modifier,
    ) {
        when (val child = it.instance) {
            is VirbetRoot.Child.VirbetChild -> VirbetContent(component = child.component)
            is VirbetRoot.Child.VirbetHomeChild -> VirbetHomeContent(component = child.component)
            is VirbetRoot.Child.VirbetListChild -> VirbetListContent(component = child.component)
            is VirbetRoot.Child.VirbetItemChild -> VirbetItemContent(component = child.component)
            is VirbetRoot.Child.VirbetSettingsChild -> VirbetSettingsContent(component = child.component)
        }
    }

}

