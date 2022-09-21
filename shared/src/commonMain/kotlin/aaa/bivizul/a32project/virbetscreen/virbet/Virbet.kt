package aaa.bivizul.a32project.virbetscreen.virbet

import aaa.bivizul.a32project.virbetentity.VirbetgEntity
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface Virbet {

    val models: Value<Model>
    val state: StateFlow<VirbetgEntity?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}