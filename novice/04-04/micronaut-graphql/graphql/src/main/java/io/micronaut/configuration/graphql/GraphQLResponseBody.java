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

package io.micronaut.configuration.graphql;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.concurrent.Immutable;
import java.util.Map;

/**
 * Represents the response body output data of an executed GraphQL query.
 *
 * @author Marcel Overdijk
 * @since 1.0
 */
@Immutable
public class GraphQLResponseBody {

    private final Map<String, Object> specification;

    /**
     * Default constructor.
     *
     * @param specification the GraphQL response body data
     */
    @JsonCreator
    public GraphQLResponseBody(Map<String, Object> specification) {
        this.specification = specification;
    }

    /**
     * Returns the GraphQL response body data.
     *
     * @return the GraphQL response body data
     */
    @JsonAnyGetter
    @JsonInclude
    public Map<String, Object> getSpecification() {
        return specification;
    }
}
