package aaa.bivizul.a32project.virbetscreen.virbetsettings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
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
            text = "VirbetSettingsContent",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
//        Button(
//            onClick = { component.onClicked() }
//        ){
//            Text("Next")
//        }

    }

}