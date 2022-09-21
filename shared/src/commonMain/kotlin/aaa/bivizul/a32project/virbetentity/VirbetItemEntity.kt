package aaa.bivizul.a32project.virbetentity

@kotlinx.serialization.Serializable
data class VirbetItemEntity(
    val id: Int,
    val virbettit: String,
    val virbetdesc: String,
    val virbetimg: String,
    val virbetinEntity: List<VirbetinEntity>,
)