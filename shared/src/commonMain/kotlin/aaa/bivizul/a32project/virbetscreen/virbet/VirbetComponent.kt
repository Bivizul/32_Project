package aaa.bivizul.a32project.virbetscreen.virbet

import com.arkivanov.decompose.ComponentContext

class VirbetComponent(
    componentContext: ComponentContext,
    private val onClick: () -> Unit
) : Virbet, ComponentContext by componentContext {

    override fun onClicked() {
        onClick()
    }
}