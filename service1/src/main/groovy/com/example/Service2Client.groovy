package com.example

import com.example.domain.Book
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Retryable
import io.reactivex.Flowable

@CircuitBreaker(delay = "5s", attempts = "5", multiplier = "3", reset = "300s")
@Retryable
@Client(id = "service2")
interface Service2Client {
    @Get("/books")
    Flowable<ArrayList<Book>> findBooks();
}