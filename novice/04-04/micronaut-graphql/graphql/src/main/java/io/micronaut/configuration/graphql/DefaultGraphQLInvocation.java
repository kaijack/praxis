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

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpRequest;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.annotation.Nullable;
import javax.inject.Singleton;

/**
 * The default implementation for invoking GraphQL requests.
 *
 * @author Marcel Overdijk
 * @author Graeme Rocher
 * @author James Kleeh
 * @since 1.0
 * @see GraphQLExecutionInputCustomizer#customize(ExecutionInput, HttpRequest)
 * @see GraphQL#executeAsync(ExecutionInput.Builder)
 */
@Singleton
public class DefaultGraphQLInvocation implements GraphQLInvocation {

    private final GraphQL graphQL;
    private final GraphQLExecutionInputCustomizer graphQLExecutionInputCustomizer;

    /**
     * Default constructor.
     *
     * @param graphQL                         the {@link GraphQL} instance
     * @param graphQLExecutionInputCustomizer the {@link GraphQLExecutionInputCustomizer} instance
     */
    public DefaultGraphQLInvocation(GraphQL graphQL, @Nullable GraphQLExecutionInputCustomizer graphQLExecutionInputCustomizer) {
        this.graphQL = graphQL;
        this.graphQLExecutionInputCustomizer = graphQLExecutionInputCustomizer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Publisher<ExecutionResult> invoke(GraphQLInvocationData invocationData, HttpRequest httpRequest) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(invocationData.getQuery())
                .operationName(invocationData.getOperationName())
                .variables(invocationData.getVariables())
                .build();
        return Flowable.fromPublisher(graphQLExecutionInputCustomizer.customize(executionInput, httpRequest))
                .flatMap(customizedExecutionInput -> Publishers.fromCompletableFuture(() ->
                        graphQL.executeAsync(customizedExecutionInput)));
    }
}
