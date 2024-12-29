/*
package com.seasec.seasec.controller;


import com.seasec.seasec.modal.Lecture;
import com.seasec.seasec.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

    @RestController
    @RequestMapping("/lectures")
    public class LectureController {

        @Autowired
        private LectureRepository lectureRepository;

        @PostMapping("/upload")
        public ResponseEntity<String> uploadLecture(@RequestParam("lectureName") String lectureName,
                                                    @RequestParam("notes") String notes,
                                                    @RequestParam("video") MultipartFile videoFile) {
            try {
                // Save the video file
                String videoFileName = videoFile.getOriginalFilename();
                String videoFilePath = "C:\\seasec\\seasec\\src\\main\\resources\\static/" + videoFileName;
                File dest = new File(videoFilePath);
                videoFile.transferTo(dest);

                String videoUrl = "http://localhost:8080/" + videoFileName;
                Lecture lecture = new Lecture();
                lecture.setLectureName(lectureName);                lecture.setNotes(notes);
                lecture.setVideoLink(videoUrl);

                lectureRepository.save(lecture);
                return ResponseEntity.ok("Lecture uploaded successfully with video URL");
            } catch (IOException e) {
                return ResponseEntity.status(500).body("File upload failed");
            }
        }
    }
*/
