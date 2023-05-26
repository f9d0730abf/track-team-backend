package de.tt.tracking.member.position.change

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/members")
class ChangePositionController(
    private val useCase: ChangePositionUseCase
) {
    data class ChangePositionRequest(
        val newLatitude: Double,
        val newLongitude: Double,
    )

    @PutMapping("/{id}/position")
    fun changePosition(
        @PathVariable("id") id: UUID,
        @RequestBody request: ChangePositionRequest,
    ) {
        useCase.changePosition(id, request.newLatitude, request.newLongitude)
    }
}
