package de.tt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrackTeamApplication

fun main(args: Array<String>) {
    runApplication<TrackTeamApplication>(*args)
}
