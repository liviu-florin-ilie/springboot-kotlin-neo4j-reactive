package com.lefe.example.controller
import com.lefe.example.model.MovieEntity
import com.lefe.example.repository.MovieRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/movies")
class MovieController(private val movieRepository: MovieRepository?) {

    @GetMapping(value = ["", "/"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getMovies(): Flux<MovieEntity?>? {
        return movieRepository?.findAll()
    }

    @PutMapping
    fun createOrUpdateMovie(@RequestBody newMovie: MovieEntity?): Mono<MovieEntity?> {
        return movieRepository!!.save(newMovie!!)
    }

    @GetMapping("/by-title")
    fun byTitle(@RequestParam title: String?): Mono<MovieEntity?>? {
        return movieRepository?.findOneByTitle(title)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: String?): Mono<Void> {
        return movieRepository!!.deleteById(id!!)
    }
}