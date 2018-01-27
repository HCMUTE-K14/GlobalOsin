package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.repository.address.DistrictRepository;
import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.DistrictService;
import org.springframework.stereotype.Service;

/**
 * Created by infamouSs on 1/27/18.
 */

@Service
public class DistrictServiceImpl extends
                                 BaseServiceImpl<District, String, DistrictRepository> implements
                                                                                       DistrictService {
    
    public DistrictServiceImpl(DistrictRepository repository) {
        super(repository);
    }
    
    @Override
    public District update(District entity) {
        return null;
    }
}
