package com.ecoresystems.greweekly.data.repository;

import com.ecoresystems.greweekly.data.entity.AnalyticalWriting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticalWritingRepository extends CrudRepository<AnalyticalWriting,Integer> {
    List<AnalyticalWriting> findAllByType(short type);
    AnalyticalWriting findById(int id);
}
