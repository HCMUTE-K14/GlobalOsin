package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.DistrictService;
import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.repository.address.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by infamouSs on 1/27/18.
 */

@Service
public class DistrictServiceImpl extends
                                 BaseServiceImpl<District, String, DistrictRepository> implements
                                                                                       DistrictService {
    
    @Autowired
    public DistrictServiceImpl(DistrictRepository repository) {
        super(repository);
    }
    
    @Override
    public District update(District entity) {
        return null;
    }
}
