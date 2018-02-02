package com.tghelper.globalosin.application.service.address;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.application.service.SearchType;
import com.tghelper.globalosin.core.entity.address.Street;
import java.util.List;

/**
 * Created by infamouSs on 1/27/18.
 */

public interface StreetService extends BaseService<Street, String> {
    
    List<Street> findStreetByType(SearchType searchType, String value);
}
