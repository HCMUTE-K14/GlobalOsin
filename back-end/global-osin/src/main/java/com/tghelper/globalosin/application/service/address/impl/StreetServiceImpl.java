package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.core.entity.address.Street;
import com.tghelper.globalosin.core.repository.address.StreetRepository;
import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.StreetService;
import org.springframework.stereotype.Service;

/**
 * Created by infamouSs on 1/27/18.
 */
@Service
public class StreetServiceImpl extends BaseServiceImpl<Street, String, StreetRepository> implements
                                                                                         StreetService {
    
    public StreetServiceImpl(StreetRepository repository) {
        super(repository);
    }
    
    @Override
    public Street update(Street entity) {
        return null;
    }
}
