package com.tghelper.globalosin.application.service.address;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.core.entity.address.Wand;
import java.util.List;

/**
 * Created by infamouSs on 1/27/18.
 */

public interface WandService extends BaseService<Wand, String> {
    
    List<Wand> findWandByType(SearchType searchType, String value);
}
