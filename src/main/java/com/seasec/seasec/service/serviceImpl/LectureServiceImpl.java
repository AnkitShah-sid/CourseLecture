package com.seasec.seasec.service.serviceImpl;

import com.seasec.seasec.modal.Lecture;
import com.seasec.seasec.repository.LectureRepository;
import com.seasec.seasec.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    private static final String VIDEO_STORAGE_PATH = "C:\\seasec\\seasec\\src\\main\\resources\\static/";


    @Override
    public String uploadLecture(String lectureName, String notes, MultipartFile videoFile) {

        try {
            String videoFileName = videoFile.getOriginalFilename();
            String videoFilePath = VIDEO_STORAGE_PATH + videoFileName;
            File dest = new File(videoFilePath);
            videoFile.transferTo(dest);

            String videoUrl = "http://localhost:8080/" + videoFileName;

            // Save lecture details in the database
            Lecture lecture = new Lecture();
            lecture.setLectureName(lectureName);
            lecture.setNotes(notes);
            lecture.setVideoFile(videoUrl);

            lectureRepository.save(lecture);

            return "Lecture uploaded successfully with video URL: " + videoUrl;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload lecture", e);
        }
    }
}