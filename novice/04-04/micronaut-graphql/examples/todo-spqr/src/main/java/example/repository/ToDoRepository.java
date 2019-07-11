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

package example.repository;

import example.domain.ToDo;

import javax.inject.Singleton;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Marcel Overdijk
 */
@Singleton
@SuppressWarnings("Duplicates")
public class ToDoRepository {

    private Map<String, ToDo> toDos = new LinkedHashMap<>();

    public ToDoRepository() {
        save(new ToDo("Book flights to Gran Canaria"));
        save(new ToDo("Order torrefacto coffee beans"));
        save(new ToDo("Watch La Casa de Papel"));
    }

    public Iterable<ToDo> findAll() {
        return toDos.values();
    }

    public ToDo findById(String id) {
        return toDos.get(id);
    }

    public ToDo save(ToDo toDo) {
        if (toDo.getId() == null) {
            toDo.setId(UUID.randomUUID().toString());
        }
        toDos.put(toDo.getId(), toDo);
        return toDo;
    }

    public void deleteById(String id) {
        toDos.remove(id);
    }
}
