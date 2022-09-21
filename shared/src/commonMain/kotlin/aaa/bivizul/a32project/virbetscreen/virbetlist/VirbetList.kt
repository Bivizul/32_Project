package aaa.bivizul.a32project.virbetscreen.virbetlist

import aaa.bivizul.a32project.virbetentity.VirbetItemEntity
import kotlinx.coroutines.flow.StateFlow

interface VirbetList {

    val state: StateFlow<List<VirbetItemEntity>?>

    fun onItemClick(id: Int)

}