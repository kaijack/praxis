package micronaut.vuejs

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import javax.annotation.Nullable

@Controller("/")
class StaticController {

    @Produces(MediaType.TEXT_HTML)
    @Get("/app{/path:.*}")
    String index(@Nullable path) {
        return new File('build/js/index.html').text
    }
  
    @Produces('text/css')
    @Get("/css{/path:.*}")
    String css(@Nullable path) {
        return new File("build/js/css/$path").text
    } 
     
    @Produces('text/javascript')
    @Get("/js{/path:.*}")
    String js(@Nullable path) {
        return new File("build/js/js/$path").text
    }  
}
