package de.tt.tracking.member

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class MongoDbMemberStorage(
    private val repo: MongoDbMemberRepository
): MemberStorage {
    override fun get(id: UUID) = repo
        .findById(id)
        .orElseThrow { NoSuchElementException() }
        .toMember()

    override fun store(member: Member) {
        repo.save(member.toDbo())
    }
}
