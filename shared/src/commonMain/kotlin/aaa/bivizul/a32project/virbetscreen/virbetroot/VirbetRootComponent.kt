package aaa.bivizul.a32project.virbetscreen.virbetroot

import aaa.bivizul.a32project.virbetrepos.VirbetItemRepository
import aaa.bivizul.a32project.virbetrepos.VirbetRepository
import aaa.bivizul.a32project.virbetscreen.virbet.Virbet
import aaa.bivizul.a32project.virbetscreen.virbet.VirbetComponent
import aaa.bivizul.a32project.virbetscreen.virbethome.VirbetHome
import aaa.bivizul.a32project.virbetscreen.virbethome.VirbetHomeComponent
import aaa.bivizul.a32project.virbetscreen.virbetitem.VirbetItem
import aaa.bivizul.a32project.virbetscreen.virbetitem.VirbetItemComponent
import aaa.bivizul.a32project.virbetscreen.virbetlist.VirbetList
import aaa.bivizul.a32project.virbetscreen.virbetlist.VirbetListComponent
import aaa.bivizul.a32project.virbetscreen.virbetsettings.VirbetSettings
import aaa.bivizul.a32project.virbetscreen.virbetsettings.VirbetSettingsComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class VirbetRootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : VirbetRoot, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val virbetRepository = VirbetRepository()
    val virbetItemRepository = VirbetItemRepository()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.VirbetConfig,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, VirbetRoot.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): VirbetRoot.Child =
        when (config) {
            is Config.VirbetConfig -> VirbetRoot.Child.VirbetChild(
                virbet(componentContext)
            )
            is Config.VirbetHomeConfig -> VirbetRoot.Child.VirbetHomeChild(
                virbetHome(componentContext)
            )
            is Config.VirbetListConfig -> VirbetRoot.Child.VirbetListChild(
                virbetList(componentContext)
            )
            is Config.VirbetItemConfig -> VirbetRoot.Child.VirbetItemChild(
                virbetItem(componentContext, config)
            )
            is Config.VirbetSettingsConfig -> VirbetRoot.Child.VirbetSettingsChild(
                virbetSettings(componentContext)
            )
        }

    private fun virbet(
        componentContext: ComponentContext
    ): Virbet = VirbetComponent(
        componentContext = componentContext,
        context = context,
        virbetRepository = virbetRepository,
        onReplaceToHome = {
            navigation.push(Config.VirbetHomeConfig)
        }
    )

    private fun virbetHome(
        componentContext: ComponentContext
    ): VirbetHome = VirbetHomeComponent(
        componentContext = componentContext,
        onClickList = {
            navigation.push(Config.VirbetListConfig)
        },
        onClickSettings = {
            navigation.push(Config.VirbetSettingsConfig)
        }
    )

    private fun virbetList(
        componentContext: ComponentContext
    ): VirbetList = VirbetListComponent(
        componentContext = componentContext,
        virbetItemRepository = virbetItemRepository,
        onVirbetItemSelected = { itemId ->
            navigation.push(Config.VirbetItemConfig(itemId = itemId))
        },
    )

    private fun virbetItem(
        componentContext: ComponentContext,
        config: Config.VirbetItemConfig
    ): VirbetItem = VirbetItemComponent(
        componentContext = componentContext,
        virbetItemRepository = virbetItemRepository,
        virbetItemId = config.itemId

    )

    private fun virbetSettings(
        componentContext: ComponentContext
    ): VirbetSettings = VirbetSettingsComponent(
        componentContext = componentContext,
//        onClick = {
//            navigation.push(Config.List)
//        }
    )

    private sealed class Config : Parcelable {
        @Parcelize
        object VirbetConfig : Config()

        @Parcelize

        object VirbetHomeConfig : Config()

        @Parcelize
        object VirbetListConfig : Config()

//        @Parcelize
//        object VirbetItemConfig : Config()

        @Parcelize
        data class VirbetItemConfig(val itemId: Int) : Config()

        @Parcelize
        object VirbetSettingsConfig : Config()
    }
}
