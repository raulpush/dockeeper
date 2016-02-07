package com.muri.web.repository;

import com.muri.web.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
@Repository("sequenceRepository")
public interface SequenceRepository extends JpaRepository<Sequence, Integer> {

    @Query("select s from Sequence s where s.elasSearchIndex = :elasSearchIndex")
    Sequence findByIndex(@Param("elasSearchIndex") String index);

}
