package aaa.bivizul.a32project.virbetscreen.virbet

import aaa.bivizul.a32project.virbetentity.VirbetEntity
import aaa.bivizul.a32project.virbetentity.VirbetgEntity
import aaa.bivizul.a32project.virbetrepos.VirbetRepository
import aaa.bivizul.a32project.virbetutil.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class VirbetComponent(
    componentContext: ComponentContext,
    context: Any,
    virbetRepository: VirbetRepository,
    private val onReplaceToHome: () -> Unit
) : Virbet, ComponentContext by componentContext {

    private val _models = MutableValue(Virbet.Model(activity = context))
    override val models: Value<Virbet.Model> = _models
    override val state: StateFlow<VirbetgEntity?> = virbetRepository.virbetg

    init {
        try {
            virbetRepository.getVirbetg(
                VirbetEntity(
                    getVirbetmm(),
                    getVirbetsim(context),
                    getVirbetid(context),
                    getVirbetl(),
                    getVirbett()
                )
            )
        } catch (e: Exception) {
            getVirbetdlg(context)
        }
    }

    override fun onReplace() {
        onReplaceToHome()
    }

}