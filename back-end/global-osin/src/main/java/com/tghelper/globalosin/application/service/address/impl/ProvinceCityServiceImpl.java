package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.ProvinceCityService;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.core.repository.address.ProvinceCityRepository;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.UpdateEntityException;
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
    public ProvinceCityServiceImpl(ProvinceCityRepository repository) {
        super(repository);
    }
    
    @Override
    public ProvinceCity update(ProvinceCity entity) {
        try {
            ProvinceCity updated = findById(entity.getId());
            
            updated.update(entity.getName(),
                      isNullOrEmptyList(entity.getDistricts())
                                ? updated.getDistricts()
                                : entity.getDistricts());
            
            return mRepository.save(updated);
        } catch (Exception ex) {
            throw new UpdateEntityException("Something went wrong when updating Province/City", ex);
        }
    }
    
    @Override
    public List<ProvinceCity> findProvinceCitiesNameLike(String name) {
        try {
            List<ProvinceCity> provinceCities = mRepository
                      .findProvinceCitiesByNameContainingIgnoreCase(name.trim());
            if (provinceCities == null) {
                throw new EntityDoesNotExistException(name + " does not exist");
            }
            
            return provinceCities;
        } catch (Exception ex) {
            throw new EntityDoesNotExistException(name + " does not exist", ex);
        }
    }
}
