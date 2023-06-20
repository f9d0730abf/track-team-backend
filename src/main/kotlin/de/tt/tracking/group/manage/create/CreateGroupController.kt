package de.tt.tracking.group.manage.create

import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@ControllerAdvice
@RequestMapping("/groups")
class CreateGroupController(private val useCase: CreateGroupUseCase) {

    data class CreateGroupRequest(val name: String, val password: String)

    @PostMapping
    fun createMember(@RequestBody request: CreateGroupRequest): UUID {
        return useCase.createGroup(request.name, request.password)
    }

    @ExceptionHandler
    fun groupAlreadyExistsExceptionHandler(exception: GroupAlreadyExists): ResponseEntity<String> =
        ResponseEntity("Group '${exception.name}' already exists.", BAD_REQUEST)
}
