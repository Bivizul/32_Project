package aaa.bivizul.a32project.virbetrepos

import aaa.bivizul.a32project.virbetapi.VirbetApi
import aaa.bivizul.a32project.virbetentity.VirbetItemEntity
import aaa.bivizul.a32project.virbetutil.virbetIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VirbetItemRepository {

    private val virbetApi = VirbetApi()
    private val virbetjob = SupervisorJob()
    private val virbetscope = CoroutineScope(virbetIoDispatcher + virbetjob)

    private val _virbetItemEntityList = MutableStateFlow<List<VirbetItemEntity>?>(null)
    val virbetItemEntityList: StateFlow<List<VirbetItemEntity>?> =
        _virbetItemEntityList.asStateFlow()

    init {
        getVirbetItem()
    }

    private fun getVirbetItem() {
        virbetscope.launch {
            val response = virbetApi.getVirbetItem()
            _virbetItemEntityList.emit(response)
        }
    }

}