package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.SearchType;
import com.tghelper.globalosin.application.service.address.WandService;
import com.tghelper.globalosin.core.entity.address.Wand;
import com.tghelper.globalosin.core.repository.address.WandRepository;
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
public class WandServiceImpl extends BaseServiceImpl<Wand, String, WandRepository> implements
                                                                                   WandService {
    
    @Autowired
    public WandServiceImpl(WandRepository repository) {
        super(repository);
    }
    
    @Override
    public Wand update(Wand entity) {
        try {
            Wand updated = findById(entity.getId());
            
            updated.update(entity.getName(),
                      isNullOrEmptyList(entity.getStreets())
                                ? updated.getStreets()
                                : entity.getStreets());
            
            return mRepository.save(updated);
        } catch (Exception ex) {
            throw new UpdateEntityException("Something went wrong when updating Wand", ex);
        }
    }
    
    @Override
    public List<Wand> findWandByType(SearchType searchType, String value) {
        try {
            if (searchType == null) {
                throw new IllegalArgumentException("Search Type is null");
            }
            value = value.trim();
            
            List<Wand> wands = new ArrayList<>();
            if (searchType == SearchType.NAME_TYPE) {
                wands.addAll(this.mRepository.findWandsByNameContainingIgnoreCase(value));
            } else if (searchType == SearchType.FOREIGN_ID_TYPE) {
                wands.addAll(this.mRepository.findWandsByDistrictId(value));
            } else if (searchType == SearchType.FOREIGN_NAME_TYPE) {
                wands.addAll(this.mRepository.findWandsByDistrictNameLike(value));
            }
            
            return wands;
        } catch (Exception ex) {
            throw new EntityDoesNotExistException("List of wand does not exist");
        }
    }
}
