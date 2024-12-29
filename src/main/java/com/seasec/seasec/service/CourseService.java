package com.seasec.seasec.service;


import com.seasec.seasec.modal.Course;
import com.seasec.seasec.modal.Lecture;

public interface CourseService {

    Course saveCourse(Course course);

    Course addLecture(String courseId, Lecture newLecture);
}
