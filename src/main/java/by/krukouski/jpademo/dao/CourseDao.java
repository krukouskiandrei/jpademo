package by.krukouski.jpademo.dao;

import by.krukouski.jpademo.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Course, Long> {

}
