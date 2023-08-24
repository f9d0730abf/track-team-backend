package de.tt.tracking.member

import java.util.UUID

interface MemberStorage {
    fun get(id: UUID): Member

    fun get(name: String): Member

    fun existsInGroup(name: String, groupId: UUID): Boolean

    fun store(member: Member)
}
