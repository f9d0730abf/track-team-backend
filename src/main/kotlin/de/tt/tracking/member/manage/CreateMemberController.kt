package de.tt.tracking.member.manage

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/members")
class CreateMemberController(private val useCase: CreateMemberUseCase) {

    data class CreateMemberRequest(val name: String)

    @PostMapping
    fun createMember(@RequestBody request: CreateMemberRequest): UUID =
        useCase.createMember(request.name)
}
