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

package example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import example.domain.ToDo;
import example.repository.ToDoRepository;

import javax.inject.Singleton;

/**
 * @author Marcel Overdijk
 */
@Singleton
@SuppressWarnings("Duplicates")
public class ToDoQueryResolver implements GraphQLQueryResolver {

    private ToDoRepository toDoRepository;

    public ToDoQueryResolver(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Iterable<ToDo> toDos() {
        return toDoRepository.findAll();
    }
}
