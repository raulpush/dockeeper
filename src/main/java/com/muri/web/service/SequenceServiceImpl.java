package com.muri.web.service;

import com.muri.web.model.Sequence;
import com.muri.web.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceRepository sequenceRepository;

    @Transactional
    public Sequence save(Sequence seq) {
        return sequenceRepository.save(seq);
    }

    public Sequence findByIndex(String index) {
        Sequence stud = sequenceRepository.findByIndex(index);

        if(stud != null) {
            return stud;
        }

        return null;
    }


}
