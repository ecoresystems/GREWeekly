package com.ecoresystems.greweekly.data.repository;

import com.ecoresystems.greweekly.data.entity.WritingAnswers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingAnswersRepository extends CrudRepository<WritingAnswers,Long> {
    Iterable<WritingAnswers> findAllByUserId(long userId);
}
