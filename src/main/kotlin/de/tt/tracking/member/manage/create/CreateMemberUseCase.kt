package de.tt.tracking.member.manage.create

import de.tt.tracking.member.Member
import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CreateMemberUseCase(
    private val storage: MemberStorage,
) {
    fun forGroup(memberName: String, groupId: UUID): Member {
        if (storage.existsInGroup(memberName, groupId)) throw MemberAlreadyExistsInGroup(memberName)

        val newMember = Member(memberName)

        storage.store(newMember)

        return newMember
    }
}

class MemberAlreadyExistsInGroup(memberName: String) :
    RuntimeException("Member with name [$memberName] already exists in group.")
