package aaa.bivizul.a32project.virbetscreen.virbetroot

import aaa.bivizul.a32project.virbetscreen.virbet.Virbet
import aaa.bivizul.a32project.virbetscreen.virbethome.VirbetHome
import aaa.bivizul.a32project.virbetscreen.virbetitem.VirbetItem
import aaa.bivizul.a32project.virbetscreen.virbetlist.VirbetList
import aaa.bivizul.a32project.virbetscreen.virbetsettings.VirbetSettings
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface VirbetRoot {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class VirbetChild(val component: Virbet) : Child()
        class VirbetHomeChild(val component: VirbetHome) : Child()
        class VirbetListChild(val component: VirbetList) : Child()
        class VirbetItemChild(val component: VirbetItem) : Child()
        class VirbetSettingsChild(val component: VirbetSettings) : Child()
    }
}