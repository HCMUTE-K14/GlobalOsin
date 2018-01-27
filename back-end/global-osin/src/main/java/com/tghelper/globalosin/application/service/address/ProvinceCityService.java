package com.tghelper.globalosin.application.service.address;

import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.application.service.BaseService;

/**
 * Created by infamouSs on 1/25/18.
 */
public interface ProvinceCityService extends BaseService<ProvinceCity, String> {
    
    ProvinceCity findProvinceCityByName(String name);
}
