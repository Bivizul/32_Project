package aaa.bivizul.a32project.virbetscreen.virbetitem

import aaa.bivizul.a32project.virbetentity.VirbetItemEntity
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface VirbetItem {

    val models: Value<Model>

    val state: StateFlow<List<VirbetItemEntity>?>

    data class Model(
        val selectedVirbetItemId: Int
    )

}