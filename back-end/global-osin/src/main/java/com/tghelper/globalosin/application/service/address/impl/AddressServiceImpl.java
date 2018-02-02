package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.AddressService;
import com.tghelper.globalosin.core.entity.address.Address;
import com.tghelper.globalosin.core.repository.address.AddressRepository;
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
        return null;
    }
}
