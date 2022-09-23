package aaa.bivizul.a32project.virbetscreen.virbethome

import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETAN
import aaa.bivizul.a32project.virbetwdg.VirbetHomeButton
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun VirbetHomeContent(
    component: VirbetHome,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = VIRBETAN,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            VirbetHomeButton(
                onClick = { component.onClickVirbetSettings() },
                text = "Settings"
            )
            VirbetHomeButton(
                onClick = { component.onClickVirbetList() },
                text = "List"
            )
        }

    }

}