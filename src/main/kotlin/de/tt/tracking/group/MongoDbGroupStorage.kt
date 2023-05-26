package de.tt.tracking.group

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class MongoDbGroupStorage(
    private val repo: MongoDbGroupRepository
): GroupStorage {
    override fun get(id: UUID) = repo
        .findById(id)
        .orElseThrow { NoSuchElementException() }
        .toGroup()

    override fun get(ids: Set<UUID>) = repo
        .findAllById(ids)
        .map(GroupDbo::toGroup)
        .toSet()

    override fun store(group: Group) {
        repo.save(group.toDbo())
    }

    override fun store(groups: Set<Group>) {
        val dbos = groups.map(Group::toDbo)

        repo.saveAll(dbos)
    }
}
