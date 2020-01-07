package demo.springbootdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import demo.springbootdemo.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}
