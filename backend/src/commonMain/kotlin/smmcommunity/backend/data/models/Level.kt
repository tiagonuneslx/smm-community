package smmcommunity.backend.data.models
import kotlinx.serialization.Serializable

@Serializable
data class Level(val id: Long, val name: String) {

    companion object {
        val mapper = { id: Long, name: String -> Level(id, name) }
    }
}