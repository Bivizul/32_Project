package aaa.bivizul.a32project.virbetscreen.virbetitem

import aaa.bivizul.a31project.especui.especwidget.Virbetcp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun VirbetItemContent(
    component: VirbetItem,
    modifier: Modifier = Modifier
) {

    val virbetItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()
    val scrollState = rememberScrollState()

    if (virbetItemList != null) {
        virbetItemList?.let { list ->
            list[model.selectedVirbetItemId - 1].let { item ->
                Column(
                    modifier = modifier
                        .verticalScroll(scrollState)
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = item.virbettit,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = item.virbetdesc,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    } else {
        Virbetcp()
    }

}