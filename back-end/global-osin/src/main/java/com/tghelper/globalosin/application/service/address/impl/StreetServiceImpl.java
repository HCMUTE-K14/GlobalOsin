package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.SearchType;
import com.tghelper.globalosin.application.service.address.StreetService;
import com.tghelper.globalosin.core.entity.address.Street;
import com.tghelper.globalosin.core.repository.address.StreetRepository;
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
public class StreetServiceImpl extends BaseServiceImpl<Street, String, StreetRepository> implements
                                                                                         StreetService {
    
    @Autowired
    public StreetServiceImpl(StreetRepository repository) {
        super(repository);
    }
    
    @Override
    public Street update(Street entity) {
        try {
            Street updated = findById(entity.getId());
            
            updated.update(entity.getName());
            
            return mRepository.save(updated);
        } catch (Exception ex) {
            throw new UpdateEntityException("Something went wrong when updating Street", ex);
        }
    }
    
    @Override
    public List<Street> findStreetByType(SearchType searchType, String value) {
        try {
            if (searchType == null) {
                throw new IllegalArgumentException("Search Type is null");
            }
            value = value.trim();
            
            List<Street> streets = new ArrayList<>();
            if (searchType == SearchType.NAME_TYPE) {
                streets.addAll(this.mRepository.findStreetsByNameContainingIgnoreCase(value));
            } else if (searchType == SearchType.FOREIGN_ID_TYPE) {
                streets.addAll(this.mRepository.findStreetsByWandId(value));
            } else if (searchType == SearchType.FOREIGN_NAME_TYPE) {
                streets.addAll(this.mRepository.findStreetsByWandNameLike(value));
            }
            
            return streets;
        } catch (Exception ex) {
            throw new EntityDoesNotExistException("List of street does not exist");
        }
    }
}
