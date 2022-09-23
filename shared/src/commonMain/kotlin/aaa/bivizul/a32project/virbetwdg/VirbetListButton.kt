package aaa.bivizul.a32project.virbetwdg

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VirbetListButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 24.dp,
            bottomEnd = 24.dp,
            bottomStart = 4.dp
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6
        )
    }

}
