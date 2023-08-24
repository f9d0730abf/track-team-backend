package de.tt.tracking.app.login.join

import de.tt.tracking.app.login.SuccessfulLogin
import de.tt.tracking.group.GroupStorage
import de.tt.tracking.group.member.add.AddMemberUseCase
import de.tt.tracking.member.manage.create.CreateMemberUseCase
import org.springframework.stereotype.Component

@Component
class LoginJoinGroupUseCase(
    private val groupStorage: GroupStorage,
    private val createMember: CreateMemberUseCase,
    private val addMember: AddMemberUseCase,
) {
    fun joinGroup(
        serverPassword: String,
        username: String,
        groupName: String,
        groupPassword: String,
    ): SuccessfulLogin {
        val group = groupStorage.get(groupName)

        if (group.password != groupPassword) throw WrongGroupPasswordException()

        val newMember = createMember.createMember(username)

        addMember.addMember(group.id, newMember.id)

        return SuccessfulLogin(group.id, newMember.id, newMember.color)
    }
}

class WrongGroupPasswordException : RuntimeException()
