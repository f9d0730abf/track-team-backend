package de.tt.tracking.group.manage.create

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/groups")
class CreateGroupController(private val useCase: CreateGroupUseCase) {

    data class CreateGroupRequest(val name: String)

    @PostMapping
    fun createMember(@RequestBody request: CreateGroupRequest): UUID =
        useCase.createGroup(request.name)
}
