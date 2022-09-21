package aaa.bivizul.a32project.virbetscreen.virbethome

import com.arkivanov.decompose.ComponentContext

class VirbetHomeComponent(
    componentContext: ComponentContext,
    private val onClickList: () -> Unit,
    private val onClickSettings: () -> Unit,

) : VirbetHome, ComponentContext by componentContext {

    override fun onClickVirbetList() {
        onClickList()
    }

    override fun onClickVirbetSettings() {
        onClickSettings()
    }
}