package com.ecoresystems.greweekly.data.repository;

import com.ecoresystems.greweekly.data.entity.AnalyticalWriting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticalWritingRepository extends CrudRepository<AnalyticalWriting,Integer> {
    Iterable<AnalyticalWriting> findAllByType(short type);
    AnalyticalWriting findById(int id);
}
