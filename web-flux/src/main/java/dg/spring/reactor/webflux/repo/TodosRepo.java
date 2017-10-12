package dg.spring.reactor.webflux.repo;

import dg.spring.reactor.webflux.documents.TodoDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by digvijayb on 09/10/17.
 */
public interface TodosRepo extends ReactiveMongoRepository<TodoDocument, ObjectId>{
}
