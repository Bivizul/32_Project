package aaa.bivizul.a32project.virbetscreen.virbetlist

import aaa.bivizul.a32project.virbetentity.VirbetItemEntity
import aaa.bivizul.a32project.virbetrepos.VirbetItemRepository
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class VirbetListComponent(
    componentContext: ComponentContext,
    virbetItemRepository: VirbetItemRepository,
    private val onVirbetItemSelected: (id: Int) -> Unit,
) : VirbetList, ComponentContext by componentContext {

    override val state: StateFlow<List<VirbetItemEntity>?> =
        virbetItemRepository.virbetItemEntityList

    override fun onItemClick(id: Int) {
        onVirbetItemSelected(id)
    }
}