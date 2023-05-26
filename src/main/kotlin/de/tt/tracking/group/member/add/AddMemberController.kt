package de.tt.tracking.group.member.add

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/groups")
class AddMemberController(private val useCase: AddMemberUseCase) {

    data class AddMemberRequest(val memberId: UUID)

    @PostMapping("/{groupId}/members")
    fun addMember(
        @PathVariable("groupId") groupId: UUID,
        @RequestBody request: AddMemberRequest,
    ) {
        useCase.addMember(groupId, request.memberId)
    }
}
