package aaa.bivizul.a32project.virbetscreen.virbetitem

import aaa.bivizul.a32project.virbetentity.VirbetItemEntity
import aaa.bivizul.a32project.virbetrepos.VirbetItemRepository
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class VirbetItemComponent(
    componentContext: ComponentContext,
    virbetItemRepository: VirbetItemRepository,
    virbetItemId: Int,
) : VirbetItem, ComponentContext by componentContext {

    private val _models = MutableValue(VirbetItem.Model(selectedVirbetItemId = virbetItemId))
    override val models: Value<VirbetItem.Model> = _models

    override val state: StateFlow<List<VirbetItemEntity>?> =
        virbetItemRepository.virbetItemEntityList

}