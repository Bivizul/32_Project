package aaa.bivizul.a32project.virbetrepos

import aaa.bivizul.a32project.virbetapi.VirbetApi
import aaa.bivizul.a32project.virbetentity.VirbetEntity
import aaa.bivizul.a32project.virbetentity.VirbetgEntity
import aaa.bivizul.a32project.virbetutil.virbetIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VirbetRepository {

    private val virbetApi = VirbetApi()
    private val virbetjob = SupervisorJob()
    private val virbetscope = CoroutineScope(virbetIoDispatcher + virbetjob)

    private val _virbetg = MutableStateFlow<VirbetgEntity?>(null)
    val virbetg: StateFlow<VirbetgEntity?> = _virbetg.asStateFlow()

    fun getVirbetg(virbetEntity: VirbetEntity) {
        virbetscope.launch {
            val response = virbetApi.getVirbetg(virbetEntity)
            _virbetg.emit(response)
        }
    }

}