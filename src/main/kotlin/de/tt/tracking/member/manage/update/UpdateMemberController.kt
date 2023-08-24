package de.tt.tracking.member.manage.update

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/members")
class UpdateMemberController(
    private val useCase: UpdateMemberUseCase
) {
    data class Properties(
        val color: Int,
    )

    @PutMapping("/{id}/properties")
    fun changePosition(
        @PathVariable("id") id: UUID,
        @RequestBody request: Properties,
    ) {
        useCase.updateProperties(id, request.color)
    }
}
