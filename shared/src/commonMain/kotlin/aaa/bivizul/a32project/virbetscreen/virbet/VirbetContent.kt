package aaa.bivizul.a32project.virbetscreen.virbet

import aaa.bivizul.a31project.especui.especwidget.Virbetcp
import aaa.bivizul.a32project.virbetentity.VirbetvarEntity
import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETDOR
import aaa.bivizul.a32project.virbetutil.getVirbetact
import aaa.bivizul.a32project.virbetutil.sigVirbetoff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.delay

@Composable
fun VirbetContent(
    component: Virbet,
    modifier: Modifier = Modifier
) {

    val virbetg by component.state.collectAsState()
    val model by component.models.subscribeAsState()



    LaunchedEffect(key1 = true) {
        delay(3000)
        virbetg?.virbetg?.let {
            if (it == VirbetvarEntity.VVNO.vv) {
                component.onReplace()
            } else if (it == VirbetvarEntity.VVNP.vv) {
                sigVirbetoff()
                component.onReplace()
            } else {
                getVirbetact(model.activity, it)
            }
        }
    }

    Virbetcp()

}