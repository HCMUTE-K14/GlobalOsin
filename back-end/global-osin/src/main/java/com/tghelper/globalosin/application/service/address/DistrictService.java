package com.tghelper.globalosin.application.service.address;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.application.service.SearchType;
import com.tghelper.globalosin.core.entity.address.District;
import java.util.List;

/**
 * Created by infamouSs on 1/27/18.
 */

public interface DistrictService extends BaseService<District, String> {
    
    List<District> findDistrictByType(SearchType searchType, String value);
}
