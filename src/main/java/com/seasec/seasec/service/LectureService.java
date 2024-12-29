package com.seasec.seasec.service;

import org.springframework.web.multipart.MultipartFile;

public interface LectureService {

    public String uploadLecture(String lectureName, String notes, MultipartFile videoFile);

    }
