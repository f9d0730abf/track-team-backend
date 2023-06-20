package de.tt.tracking.group

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document("groups")
data class GroupDbo(
    @Id val id: UUID,
    val password: String,
    val name: String,
    val members: Set<GroupMember>,
) {
    fun toGroup() = Group(id, password, name, members)
}

fun Group.toDbo() = GroupDbo(id, password, name, members)
