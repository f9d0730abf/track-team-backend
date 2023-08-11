package de.tt.tracking.group

import de.tt.tracking.member.Member
import de.tt.tracking.member.MemberDbo
import de.tt.tracking.member.toDbo
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID

@Entity
class GroupDbo(
    @Id val id: UUID,
    val password: String,
    val name: String,
    @OneToMany(cascade = [CascadeType.ALL])
    val members: Set<MemberDbo>,
) {
    fun toGroup() = Group(id, password, name, members.toMembers())
}

private fun Set<MemberDbo>.toMembers() = map { it.toMember() }.toSet()

fun Group.toDbo() = GroupDbo(id, password, name, members.toDbo())

private fun Set<Member>.toDbo() = map { it.toDbo() }.toSet()
