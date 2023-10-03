package com.lefe.example

import com.lefe.example.repository.MovieRepository
import com.lefe.example.util.PackageScanner
import org.neo4j.driver.Driver
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories


@Configuration
@EnableReactiveNeo4jRepositories(basePackageClasses = [MovieRepository::class] )
@SpringBootApplication
class Application(private val packageScanner: PackageScanner) {

    @Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
        return CommandLineRunner { _: Array<String> ->
            println("Spring Boot app started: ${ctx.applicationName}")
            packageScanner.logScannedPackages()

        }
    }

    @Bean
    fun reactiveTransactionManager(
        driver: Driver?,
        databaseNameProvider: ReactiveDatabaseSelectionProvider?
    ): ReactiveNeo4jTransactionManager? {
        return ReactiveNeo4jTransactionManager(driver!!, databaseNameProvider!!)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Application>(*args)
        }
    }
}
