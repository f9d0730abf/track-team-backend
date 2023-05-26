package de.tt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class TrackTeamApplication

fun main(args: Array<String>) {
    runApplication<TrackTeamApplication>(*args)
}
