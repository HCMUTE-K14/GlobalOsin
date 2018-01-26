package com.tghelper.globalosin.application.service.address;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import java.util.List;

/**
 * Created by infamouSs on 1/25/18.
 */
public interface ProvinceCityService extends BaseService<ProvinceCity, String> {
    
    List<ProvinceCity> findProvinceCityByName(String name);
}
