package com.example.myApplication.service;

import com.example.myApplication.model.Course;
import com.example.myApplication.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository ;

    @Override
    public List<Course> retrieveCourses()
    {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> retrieveCourse(int courseId) { return courseRepository.findById(courseId); }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public String deleteCourse(int courseId) {
        Course courseToDelete = courseRepository.getOne(courseId);
        String msg;
        if(!courseToDelete.equals(null)) {
             courseRepository.delete(courseToDelete);
             msg="Course deleted Successfull with id:"+ courseId;
        } else {
            msg="No Course found with id:"+ courseId + ".Hence couldnt delete";
        }
        return msg;
    }

    @Override
    public Course updateCourse(int courseId, Course course) {
        course.setId(courseId);
        courseRepository.save(course);
        return course;
    }

}



/*

* never put @Component (or @Service, ...) at an interface, because this make the interface useless.
* @Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and
   *    pull it into the application context.
* @Repository annotation is a specialization of the @Component annotation specifically for DAOs. In addition to
   *    importing the DAOs into the DI container, it also makes the unchecked exceptions (thrown from DAO methods)
   *    eligible for translation into Spring DataAccessException.
* @Service annotation is also a specialization of the component annotation.It doesn’t currently provide any additional
  *    behavior over the @Component annotation.but it’s a good idea to use @Service over @Component in service-layer
  *    classes because it specifies intent better.
*@Controller annotation marks a class as a Spring Web MVC controller.
* autowire the interface and not the implemented class
*/