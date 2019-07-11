package micronaut.vuejs

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces

@Controller("/")
class IndexController {

    @Get("/")
    @Produces('text/plain')
    String index() {
        return "Hello, your application is working!"
    }

    @Get("/api/data")
    List data() {
        ["cat","tree","camel","dog","house"]
    }
}
