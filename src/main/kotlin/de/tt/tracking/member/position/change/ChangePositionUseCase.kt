package de.tt.tracking.member.position.change

import de.tt.tracking.group.GroupStorage
import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ChangePositionUseCase(
    private val memberStorage: MemberStorage,
    private val groupStorage: GroupStorage,
) {
    fun changePosition(id: UUID, newLatitude: Double, newLongitude: Double) {
        val member = memberStorage.get(id)

        val groups = groupStorage.get(member.groups)

        val updatedGroups = groups
            .map { it.changePosition(id, newLatitude, newLongitude) }
            .toSet()

        groupStorage.store(updatedGroups)
    }
}
