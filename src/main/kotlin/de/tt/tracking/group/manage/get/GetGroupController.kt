package de.tt.tracking.group.manage.get

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@ControllerAdvice
@RequestMapping("/groups")
class GetGroupController(private val useCase: GetGroupUseCase) {
    @GetMapping("/{groupId}")
    fun getGroup(
        @PathVariable("groupId") groupId: UUID,
        @RequestParam("memberId") memberId: UUID,
    ): Group = useCase.getGroup(groupId, memberId)
}
