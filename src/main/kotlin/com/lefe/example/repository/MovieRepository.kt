package com.lefe.example.repository

import com.lefe.example.model.MovieEntity
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
interface MovieRepository : ReactiveNeo4jRepository<MovieEntity?, String?> {
    fun findOneByTitle(title: String?): Mono<MovieEntity?>?
}