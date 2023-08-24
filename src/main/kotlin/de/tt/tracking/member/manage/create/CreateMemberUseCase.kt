package de.tt.tracking.member.manage.create

import de.tt.tracking.member.Member
import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component

@Component
class CreateMemberUseCase(
    private val storage: MemberStorage
) {
    fun createMember(name: String): Member {
        if (storage.exists(name)) throw MemberAlreadyExists(name)

        val newMember = Member(name)

        storage.store(newMember)

        return newMember
    }
}

class MemberAlreadyExists(
    val name: String
): RuntimeException()
