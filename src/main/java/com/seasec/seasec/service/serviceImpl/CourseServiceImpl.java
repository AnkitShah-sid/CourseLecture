package com.seasec.seasec.service.serviceImpl;

import com.seasec.seasec.modal.Course;
import com.seasec.seasec.modal.Lecture;
import com.seasec.seasec.repository.CourseRepository;
import com.seasec.seasec.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course addLecture(String courseId, Lecture newLecture) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        course.getLectures().add(newLecture);
        return courseRepository.save(course);
    }

}
