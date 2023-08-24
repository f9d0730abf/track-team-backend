package de.tt.tracking.member

import de.tt.tracking.NoId
import de.tt.tracking.Position
import java.util.UUID

data class Member(
    val id: UUID,
    val name: String,
    val color: Int,
    val position: Position,
    val groups: Set<UUID>,
) {
    constructor(name: String) : this(
        UUID.randomUUID(),
        name,
        randomColor(),
        Position(),
        emptySet(),
    )

    fun addGroup(groupId: UUID): Member {
        if (groups.any { it == groupId }) return this

        return copy(groups = groups + groupId)
    }

    fun changePosition(newLatitude: Double, newLongitude: Double) = copy(
        position = position.change(newLatitude, newLongitude)
    )

    fun changeProperties(color: Int = this.color) = copy(
        color = color
    )

    companion object {
        private const val OPAQUE_BLACK = 0xff000000
        private const val OPAQUE_WHITE = 0xffffffff
        private fun randomColor() = (OPAQUE_BLACK..OPAQUE_WHITE).random().toInt()
    }
}

val NoMember = Member(NoId, "NoName", 0, Position(), emptySet())
