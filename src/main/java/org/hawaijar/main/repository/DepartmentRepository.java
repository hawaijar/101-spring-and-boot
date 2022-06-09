package org.hawaijar.main.repository;

import org.hawaijar.main.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
	@Query("{name:'?0'}")
	Department findOne(String name);
	List<Department> findAll();
}
