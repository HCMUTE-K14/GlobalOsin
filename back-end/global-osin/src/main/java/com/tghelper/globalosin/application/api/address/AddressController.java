package com.tghelper.globalosin.application.api.address;

import com.tghelper.globalosin.application.api.AbstractApiController;
import com.tghelper.globalosin.application.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by infamouSs on 1/29/18.
 */
@RestController
public class AddressController extends AbstractApiController {
    
    private final AddressService mAddressService;
    
    public static final String BASE_URL = "/addresses";
    
    
    @Autowired
    public AddressController(AddressService mAddressService) {
        this.mAddressService = mAddressService;
    }
}
