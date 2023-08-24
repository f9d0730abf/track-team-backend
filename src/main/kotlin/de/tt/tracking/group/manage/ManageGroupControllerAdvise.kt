package de.tt.tracking.group.manage

import de.tt.tracking.app.login.join.InvalidGroupPasswordException
import de.tt.tracking.group.manage.create.GroupAlreadyExists
import de.tt.tracking.group.manage.get.GroupWithIdDoesNotExist
import de.tt.tracking.group.manage.get.GroupWithNameDoesNotExist
import de.tt.tracking.member.manage.create.MemberAlreadyExistsInGroup
import de.tt.tracking.member.manage.update.MemberWithIdDoesNotExist
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ManageGroupControllerAdvise {
    @ExceptionHandler(
        GroupAlreadyExists::class,
        GroupWithIdDoesNotExist::class,
        GroupWithNameDoesNotExist::class,
        MemberAlreadyExistsInGroup::class,
        MemberWithIdDoesNotExist::class,
        InvalidGroupPasswordException::class,
    )
    fun handleDomainExceptions(exception: Exception) = ResponseEntity<String>(exception.message, HttpStatus.BAD_REQUEST)
}
