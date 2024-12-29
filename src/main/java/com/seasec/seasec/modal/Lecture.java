package com.seasec.seasec.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {

    @Id
    private String id;
    private String lectureName;
    private String notes;
    private String videoFile;
}
