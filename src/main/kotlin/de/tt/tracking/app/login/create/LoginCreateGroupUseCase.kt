package de.tt.tracking.app.login.create

import de.tt.tracking.app.login.SuccessfulLogin
import de.tt.tracking.group.manage.create.CreateGroupUseCase
import de.tt.tracking.group.member.add.AddMemberUseCase
import de.tt.tracking.member.manage.create.CreateMemberUseCase
import org.springframework.stereotype.Component

@Component
class LoginCreateGroupUseCase(
    private val createGroup: CreateGroupUseCase,
    private val createMember: CreateMemberUseCase,
    private val addMember: AddMemberUseCase,
) {
    fun createGroup(
        serverPassword: String,
        username: String,
        groupName: String,
        groupPassword: String,
    ): SuccessfulLogin {
        val newMember = createMember.createMember(username)
        val newGroup = createGroup.createGroup(groupName, groupPassword)

        addMember.addMember(newGroup, newMember)

        return SuccessfulLogin(newGroup, newMember)
    }
}