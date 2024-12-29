package com.seasec.seasec.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    private String id;
    private String courseName;
    private String courseDescription;

    @DBRef
    private List<Lecture> lectures;
}
