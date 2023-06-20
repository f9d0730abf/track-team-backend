package de.tt.tracking.member.manage.create

import de.tt.tracking.member.Member
import de.tt.tracking.member.MemberStorage
import de.tt.tracking.member.NoMember
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CreateMemberUseCase(
    private val storage: MemberStorage
) {
    fun createMember(name: String): UUID {
        if (storage.exists(name)) throw MemberAlreadyExists(name)

        val newMember = Member(name)

        storage.store(newMember)

        return newMember.id
    }
}

class MemberAlreadyExists(
    val name: String
): RuntimeException()
