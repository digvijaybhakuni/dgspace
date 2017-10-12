package dg.spring.reactor.webflux.documents;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by digvijayb on 09/10/17.
 */
@Document(collection = "tasks")
@Data
public class TodoDocument {

    @Id
    private ObjectId _id;
    private String title;
    private Boolean complete;

}
