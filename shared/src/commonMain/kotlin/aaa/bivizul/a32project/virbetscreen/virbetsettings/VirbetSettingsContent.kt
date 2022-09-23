package aaa.bivizul.a32project.virbetscreen.virbetsettings

import aaa.bivizul.a32project.virbetwdg.Virbetswitch
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun VirbetSettingsContent(
    component: VirbetSettings,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Notifications",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Virbetswitch()
        }

    }
}