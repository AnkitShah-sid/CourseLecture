package com.seasec.seasec.repository;

import com.seasec.seasec.modal.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends MongoRepository<Lecture, String> {
}
