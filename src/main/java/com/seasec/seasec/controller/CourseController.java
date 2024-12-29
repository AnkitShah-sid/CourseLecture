package com.seasec.seasec.controller;


import com.seasec.seasec.DTO.SaveCourseAndLecturesRequest;
import com.seasec.seasec.modal.Course;
import com.seasec.seasec.modal.Lecture;
import com.seasec.seasec.service.CourseService;
import com.seasec.seasec.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {


    @Autowired
    private CourseService courseService;

    @Autowired
    private LectureService lectureService;

    // POST endpoint to save the course
    @PostMapping("/save")
    public ResponseEntity<String> saveCourse(@RequestBody Course course) {
        try {
            // Save the course
            Course savedCourse = courseService.saveCourse(course);

            return ResponseEntity.status(HttpStatus.CREATED).body("Course saved successfully with ID: " + savedCourse.getId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to save course: " + e.getMessage());
        }
    }

    @PostMapping("/{courseId}/add-lecture")
    public ResponseEntity<String> addLectureToCourse(
            @PathVariable String courseId,  // Path variable for course ID
            @RequestParam("lectureName") String lectureName,  // Request param for lecture name
            @RequestParam("notes") String notes,  // Request param for notes
            @RequestParam("videoFile") MultipartFile videoFile) {  // Request param for video file

        try {
            // Call the service to upload the lecture and associate it with the course
            String result = lectureService.uploadLecture(lectureName, notes, videoFile);

            // Assuming the service method successfully uploads and saves the lecture
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add lecture: " + e.getMessage());
        }
  }
}
