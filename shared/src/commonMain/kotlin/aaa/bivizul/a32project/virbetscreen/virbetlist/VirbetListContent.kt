package aaa.bivizul.a32project.virbetscreen.virbetlist

import aaa.bivizul.a32project.virbetwdg.Virbetcp
import aaa.bivizul.a32project.virbetwdg.VirbetListButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VirbetListContent(
    component: VirbetList,
    modifier: Modifier = Modifier
) {

    val virbetItemList by component.state.collectAsState()

    if (virbetItemList != null) {
        virbetItemList?.let { list ->
            LazyColumn(
                modifier = modifier.padding(6.dp).fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                items(list) { virbetItem ->
                    VirbetListButton(
                        onClick = { component.onItemClick(id = virbetItem.id) },
                        text = virbetItem.virbettit
                    )
                }
            }
        }
    } else {
        Virbetcp(modifier = modifier)
    }

}