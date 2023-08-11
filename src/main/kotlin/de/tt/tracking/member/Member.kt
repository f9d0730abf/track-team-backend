package de.tt.tracking.member

import de.tt.tracking.NoId
import de.tt.tracking.Position
import java.util.UUID

data class Member(
    val id: UUID,
    val name: String,
    val position: Position,
    val groups: Set<UUID>,
) {
    constructor(name: String) : this(
        UUID.randomUUID(),
        name,
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
}

val NoMember = Member(NoId, "NoName", Position(), emptySet())
