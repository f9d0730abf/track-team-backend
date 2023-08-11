package de.tt.tracking.member

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class JpaMemberStorage(
    private val repo: JpaMemberRepository
): MemberStorage {
    override fun get(id: UUID) = repo
        .findById(id)
        .orElseThrow { NoSuchElementException() }
        .toMember()

    override fun get(name: String): Member = repo
        .findByName(name)
        .map(MemberDbo::toMember)
        .orElse(NoMember)

    override fun exists(name: String): Boolean = repo
        .existsByName(name)

    override fun store(member: Member) {
        repo.save(member.toDbo())
    }
}
