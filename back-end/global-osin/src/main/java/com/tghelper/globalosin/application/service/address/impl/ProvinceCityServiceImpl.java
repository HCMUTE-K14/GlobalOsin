package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.ProvinceCityService;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.core.repository.address.ProvinceCityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by infamouSs on 1/27/18.
 */

@Service
public class ProvinceCityServiceImpl extends
                                 BaseServiceImpl<ProvinceCity, String, ProvinceCityRepository> implements
                                                                                               ProvinceCityService {
    
    @Autowired
    public ProvinceCityServiceImpl(
              ProvinceCityRepository repository) {
        super(repository);
    }
    
    @Override
    public ProvinceCity update(ProvinceCity entity) {
        ProvinceCity updaded = findById(entity.getId());
        return null;
    }
    
    @Override
    public List<ProvinceCity> findProvinceCityByName(String name) {
        return null;
    }
}
