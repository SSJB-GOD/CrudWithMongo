package com.jitesh.CrudUsingMongodb.Repo;

import com.jitesh.CrudUsingMongodb.Model.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentsRepository extends MongoRepository<Students, String>{



}

