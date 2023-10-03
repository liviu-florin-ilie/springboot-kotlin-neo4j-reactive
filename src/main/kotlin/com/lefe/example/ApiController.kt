package com.lefe.example;

import com.lefe.example.repository.MovieRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")
class ApiController(private val movieRepository: MovieRepository?){

    @RequestMapping("/")
    fun index(): String {
        return "Greetings from Spring Kotlin Boot + Tanzu!";
    }

}