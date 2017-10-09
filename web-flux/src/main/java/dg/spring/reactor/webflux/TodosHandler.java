package dg.spring.reactor.webflux;

import dg.spring.reactor.webflux.documents.TodoDocument;
import dg.spring.reactor.webflux.repo.TodosRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digvijayb on 09/10/17.
 */
@RestController
@RequestMapping("api/todos")
public class TodosHandler {

    @Autowired
    private TodosRepo todosRepo;

    @GetMapping()
    public Flux<TodoDocument> getTodos() {
        return todosRepo.findAll();
    }

    @GetMapping("{id}")
    public Mono<TodoDocument> getTodo(@PathVariable("id")final  String id){
        return todosRepo.findById(Mono.just(id).map(ObjectId::new));
    }

//    @DeleteMapping("{todo}")
//    public void delete(@PathVariable("todo") String todo){
//        lst.remove(todo);
//    }

}
