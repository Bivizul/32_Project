package aaa.bivizul.a32project.virbetscreen.virbetlist

import com.arkivanov.decompose.ComponentContext

class VirbetListComponent(
    componentContext: ComponentContext,
    private val onClick: () -> Unit
) : VirbetList, ComponentContext by componentContext {

    override fun onClicked() {
        onClick()
    }
}