package de.tt.tracking.group.manage.create

import de.tt.tracking.group.Group
import de.tt.tracking.group.GroupStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CreateGroupUseCase(
    private val storage: GroupStorage
) {
    fun createGroup(name: String): UUID {
        val group = Group(name)

        storage.store(group)

        return group.id
    }
}
