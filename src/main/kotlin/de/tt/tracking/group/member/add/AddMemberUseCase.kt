package de.tt.tracking.group.member.add

import de.tt.tracking.group.GroupStorage
import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AddMemberUseCase(
    private val groupStorage: GroupStorage,
    private val memberStorage: MemberStorage,
) {
    fun addMember(groupId: UUID, memberId: UUID) {
        val group = groupStorage.get(groupId)
        val newMember = memberStorage.get(memberId)

        val updatedGroup = group.addMember(newMember)
        val updatedMember = newMember.addGroup(groupId)

        groupStorage.store(updatedGroup)
        memberStorage.store(updatedMember)
    }
}
