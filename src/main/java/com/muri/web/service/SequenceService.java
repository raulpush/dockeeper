package com.muri.web.service;

import com.muri.web.model.Sequence;
import org.springframework.stereotype.Service;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
public interface SequenceService {
    Sequence save(Sequence seq);
    Sequence findByIndex(String index);
}
