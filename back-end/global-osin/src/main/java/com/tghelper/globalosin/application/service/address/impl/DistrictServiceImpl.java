package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.SearchType;
import com.tghelper.globalosin.application.service.address.DistrictService;
import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.repository.address.DistrictRepository;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.UpdateEntityException;
import java.util.ArrayList;
import java.util.List;
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
        try {
            District updated = findById(entity.getId());
            
            updated.update(entity.getName(), isNullOrEmptyList(entity.getWands())
                      ? updated.getWands() : entity.getWands());
            
            return mRepository.save(updated);
        } catch (Exception ex) {
            throw new UpdateEntityException("Something went wrong when updating District", ex);
        }
    }
    
    @Override
    public List<District> findDistrictByType(SearchType searchType, String value) {
        try {
            if (searchType == null) {
                throw new IllegalArgumentException("Search Type is null");
            }
            value = value.trim();
            
            List<District> districts = new ArrayList<>();
            if (searchType == SearchType.NAME_TYPE) {
                districts.addAll(this.mRepository.findDistrictsByNameContainingIgnoreCase(value));
            } else if (searchType == SearchType.FOREIGN_ID_TYPE) {
                districts.addAll(this.mRepository.findDistrictsByProvinceCityId(value));
            } else if (searchType == SearchType.FOREIGN_NAME_TYPE) {
                districts.addAll(this.mRepository.findDistrictsByProvinceCityNameLike(value));
            }
            
            return districts;
        } catch (Exception ex) {
            throw new EntityDoesNotExistException("List of district does not exist");
        }
    }
}
