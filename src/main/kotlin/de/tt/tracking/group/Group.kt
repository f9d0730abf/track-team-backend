package de.tt.tracking.group

import de.tt.tracking.NoPosition
import de.tt.tracking.Position
import de.tt.tracking.PositionState.ACTIVE
import de.tt.tracking.member.Member
import java.time.LocalDateTime.now
import java.util.UUID

data class Group(
    val id: UUID,
    val password: String,
    val name: String,
    val members: Set<GroupMember>,
) {
    constructor(name: String, password: String) : this(UUID.randomUUID(), password, name, emptySet())

    fun changePosition(memberId: UUID, newLatitude: Double, newLongitude: Double): Group {
        val newMembers = members
            .filter { it.id == memberId }
            .map { it.changePosition(newLatitude, newLongitude) }
            .toSet()

        return copy(members = newMembers)
    }

    fun addMember(newMember: Member): Group {
        val newMembers = members + GroupMember(newMember.id, newMember.name)

        return copy(members = newMembers)
    }
}

val NoGroup = Group(UUID.fromString("00000000-0000-0000-0000-000000000000"), "NoPassword","NoGroup", emptySet())

data class GroupMember(
    val id: UUID,
    val name: String,
    val position: Position,
) {
    constructor(id: UUID, name: String) : this(id, name, NoPosition)

    fun changePosition(newLatitude: Double, newLongitude: Double) = copy(
        position = Position(
            ACTIVE,
            newLatitude,
            newLongitude,
            now()
        )
    )
}
