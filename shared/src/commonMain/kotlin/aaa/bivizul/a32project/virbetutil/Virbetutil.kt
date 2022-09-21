package aaa.bivizul.a32project.virbetutil

import kotlin.coroutines.CoroutineContext

internal expect val virbetIoDispatcher: CoroutineContext
internal expect val virbetUiDispatcher: CoroutineContext

internal expect fun getVirbetmm(): String
internal expect fun getVirbetsim(virbetcon: Any): String
internal expect fun getVirbetid(virbetcon: Any): String
internal expect fun getVirbetl(): String
internal expect fun getVirbett(): String
internal expect fun getVirbetdlg(virbetcon: Any)
internal expect fun checkVirbetnet(virbetcon: Any): Boolean
internal expect fun sigVirbetoff()
internal expect fun getVirbetactoff(virbetcon: Any)
