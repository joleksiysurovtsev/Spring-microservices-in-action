package com.o.surovtsev.controller

import com.o.surovtsev.domain.HelloRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["hello"])
class HelloController {

    @GetMapping(value = ["/{firstName}"])
    fun helloString(
        @PathVariable("firstName") firstName: String,
        @RequestParam("lastName") lastName: String
    ): String {
        return String.format(
            "{\"message\":\"Hello %s\"}", HelloRequest(firstName, lastName)
        )
    }
}