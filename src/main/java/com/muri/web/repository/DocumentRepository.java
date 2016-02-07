package com.muri.web.repository;

import com.muri.web.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
@Repository("documentRepository")
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("select s from Document s where s.origTitle = :title")
    Document findByName(@Param("title") String title);


    @Query("select s from Document s where s.company = :company")
    List<Document> getCompanyDocuments(@Param("company") String company);

}
