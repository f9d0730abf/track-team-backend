package de.tt.tracking.group

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class JpaGroupStorage(
    private val repo: JpaGroupRepository
): GroupStorage {
    override fun get(id: UUID) = repo
        .findById(id)
        .orElseThrow { GroupWithIdDoesNotExist(id) }
        .toGroup()

    override fun get(ids: Set<UUID>) = repo
        .findAllById(ids)
        .map(GroupDbo::toGroup)
        .toSet()

    override fun get(name: String): Group = repo
        .findByName(name)
        .map(GroupDbo::toGroup)
        .orElseThrow { GroupWithNameDoesNotExist(name) }

    override fun exists(name: String): Boolean = repo
        .existsByName(name)

    override fun store(group: Group) {
        repo.save(group.toDbo())
    }

    override fun store(groups: Set<Group>) {
        val dbos = groups.map(Group::toDbo)

        repo.saveAll(dbos)
    }
}

class GroupWithNameDoesNotExist(val name: String): RuntimeException()

class GroupWithIdDoesNotExist(val id: UUID): RuntimeException()
