package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Logs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LogsRepository extends MongoRepository<Logs, String> {
    // the reason text search is not used here is because text search in mongodb does not support partial match,
    // eg:  'admin' can NOT be searched if only 'admi' is inputed
    @Query(value = "{$or:[{'url':/.*?0.*/i},{'httpMethod':/.*?0.*/i},{'protocol':/.*?0.*/i},{'statusCode':/.*?0.*/i},{'contentType':/.*?0.*/i}]}")
    Page<Logs> findInAllFields(String q, Pageable pageable);

}