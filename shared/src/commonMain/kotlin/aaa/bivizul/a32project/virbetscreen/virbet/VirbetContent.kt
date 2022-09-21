package aaa.bivizul.a32project.virbetscreen.virbet

import aaa.bivizul.a31project.especui.especwidget.Virbetcp
import aaa.bivizul.a32project.virbetentity.VirbetvarEntity
import aaa.bivizul.a32project.virbetutil.sigVirbetoff
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun VirbetContent(
    component: Virbet,
    modifier: Modifier = Modifier
) {

    val virbetg by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    println("VirbetContent virbetg : ${virbetg?.virbetg}")

    Virbetcp()

//    LaunchedEffect(Unit) {
//        delay(1000)
    virbetg?.virbetg?.let {

        println("VirbetContent it : $it")

        if (it == VirbetvarEntity.VVNO.vv) {
            component.onReplace()
        } else if (it == VirbetvarEntity.VVNP.vv) {
            sigVirbetoff()
            component.onReplace()
        } else {
//            getVirbetact(model.activity, it)
        }
    }

}