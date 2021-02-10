package org.tarodbofh.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ExampleApp

fun main(args: Array<String>) {
    runApplication<ExampleApp>(*args)
}
