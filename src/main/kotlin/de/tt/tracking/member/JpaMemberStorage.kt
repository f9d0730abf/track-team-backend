package de.tt.tracking.member

import de.tt.tracking.member.manage.update.MemberWithIdDoesNotExist
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class JpaMemberStorage(
    private val repo: JpaMemberRepository,
) : MemberStorage {
    override fun get(id: UUID) = repo
        .findById(id)
        .orElseThrow { MemberWithIdDoesNotExist(id) }
        .toMember()

    override fun get(name: String): Member = repo
        .findByName(name)
        .map(MemberDbo::toMember)
        .orElse(NoMember)

    override fun existsInGroup(name: String, groupId: UUID): Boolean = repo
        .existsByNameAndGroupsContains(name, groupId)

    override fun store(member: Member) {
        repo.save(member.toDbo())
    }
}
