package de.tt.tracking.group.manage.create

import de.tt.tracking.group.Group
import de.tt.tracking.group.GroupStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CreateGroupUseCase(
    private val storage: GroupStorage
) {
    fun createGroup(name: String, password: String): UUID {
        if (storage.exists(name)) throw GroupAlreadyExists(name)

        val group = Group(name, password)

        storage.store(group)

        return group.id
    }
}

class GroupAlreadyExists(
    val name: String
): RuntimeException("Group with name [$name] already exists")
