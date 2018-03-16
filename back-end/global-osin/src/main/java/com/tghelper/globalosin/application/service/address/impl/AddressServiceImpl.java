package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.SearchType;
import com.tghelper.globalosin.application.service.address.AddressService;
import com.tghelper.globalosin.core.entity.address.Address;
import com.tghelper.globalosin.core.repository.address.AddressRepository;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.UpdateEntityException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by infamouSs on 1/31/18.
 */
@Service
public class AddressServiceImpl extends
                                BaseServiceImpl<Address, String, AddressRepository> implements
                                                                                    AddressService {
    
    @Autowired
    protected AddressServiceImpl(
              AddressRepository repository) {
        super(repository);
    }
    
    @Override
    public Address update(Address entity) {
        try {
            Address updated = findById(entity.getId());
            
            updated.update(entity.getFullAddress(), entity.getLatitude(), entity.getLongitude(),
                      entity.getStreet(), entity.getWand(), entity.getStreet(), 
                      entity.getProvinceCity());
            
            return mRepository.save(updated);
        } catch (Exception ex) {
            throw new UpdateEntityException("Something went wrong when updating Address", ex);
        }
    }
    
    @Override
    public List<Address> findAddressByType(SearchType searchType, String value) {
        try {
            if (searchType == null) {
                throw new IllegalArgumentException("Search Type is null");
            }
            value = value.trim();
            
            List<Address> addresses = new ArrayList<>();
            if (searchType == SearchType.ADDRESS_PROVINCE_NAME) {
                addresses.addAll(this.mRepository.findAddressByProvinceCityNameLike(value));
            } else if (searchType == SearchType.ADDRESS_DISTRICT_NAME) {
                addresses.addAll(this.mRepository.findAddressByDistrictNameLike(value));
            } else if (searchType == SearchType.ADDRESS_WAND_NAME) {
                addresses.addAll(this.mRepository.findAddressByWandNameLike(value));
            } else if (searchType == SearchType.ADDRESS_STREET_NAME) {
                addresses.addAll(this.mRepository.findAddressByStreetNameLike(value));
            } else if (searchType == SearchType.ADDRESS_NAME) {
                addresses.addAll(
                          this.mRepository.findAddressByFullAddressContainingIgnoreCase(value));
            } else if (searchType == SearchType.ADDRESS_PROVINCE_ID) {
                addresses.addAll(this.mRepository.findAddressByProvinceCityId(value));
            } else if (searchType == SearchType.ADDRESS_DISTRICT_ID) {
                addresses.addAll(this.mRepository.findAddressByDistrictId(value));
            } else if (searchType == SearchType.ADDRESS_WAND_ID) {
                addresses.addAll(this.mRepository.findAddressByWandId(value));
            } else if (searchType == SearchType.ADDRESS_STREET_ID) {
                addresses.addAll(this.mRepository.findAddressByStreetId(value));
            }
            
            return addresses;
        } catch (Exception ex) {
            throw new EntityDoesNotExistException("List of street does not exist");
        }
    }
}
