/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.micronaut.configuration.graphql

import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.Specification

import static io.micronaut.http.HttpRequest.GET
import static io.micronaut.http.MediaType.TEXT_HTML

/**
 * @author Marcel Overdijk
 * @since 1.0
 */
class GraphiQLControllerSpec extends Specification {

    void "test simple get"() {
        given:
        EmbeddedServer embeddedServer = ApplicationContext.run(
                EmbeddedServer,
                ["spec.name"       : GraphiQLControllerSpec.simpleName,
                 "graphql.graphiql.enabled": true],
                Environment.TEST)
        HttpClient client = embeddedServer.applicationContext.createBean(HttpClient, embeddedServer.getURL())

        when:
        HttpResponse response = client.toBlocking().exchange(GET("/graphiql"), String)

        then:
        response.status() == HttpStatus.OK
        response.contentType.get().toString() == TEXT_HTML + ";charset=UTF-8"

        cleanup:
        embeddedServer.close()
    }
}
