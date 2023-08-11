package de.tt.tracking.group

import de.tt.tracking.member.Member
import java.util.UUID

data class Group(
    val id: UUID,
    val password: String,
    val name: String,
    val members: Set<Member>,
) {
    constructor(name: String, password: String) : this(UUID.randomUUID(), password, name, emptySet())

    fun addMember(newMember: Member): Group {
        if (members.any { it.id == newMember.id }) return this

        val newMembers = members + newMember

        return copy(members = newMembers)
    }
}
