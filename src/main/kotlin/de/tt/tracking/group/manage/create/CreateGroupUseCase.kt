package de.tt.tracking.group.manage.create

import de.tt.tracking.group.Group
import de.tt.tracking.group.GroupStorage
import de.tt.tracking.group.NoGroup
import org.springframework.stereotype.Component
import java.lang.RuntimeException
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
): RuntimeException()
