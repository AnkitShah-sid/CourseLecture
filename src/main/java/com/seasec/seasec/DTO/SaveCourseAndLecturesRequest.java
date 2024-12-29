package com.seasec.seasec.DTO;

import com.seasec.seasec.modal.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveCourseAndLecturesRequest {

    private String courseName;
    private String courseDescription;
    private List<Lecture> lectures;
}
