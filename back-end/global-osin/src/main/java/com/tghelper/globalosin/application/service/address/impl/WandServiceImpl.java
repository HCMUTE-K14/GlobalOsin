package com.tghelper.globalosin.application.service.address.impl;

import com.tghelper.globalosin.core.entity.address.Wand;
import com.tghelper.globalosin.core.repository.address.WandRepository;
import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.address.WandService;
import org.springframework.stereotype.Service;

/**
 * Created by infamouSs on 1/27/18.
 */
@Service
public class WandServiceImpl extends BaseServiceImpl<Wand, String, WandRepository> implements
                                                                                   WandService {
    
    public WandServiceImpl(WandRepository repository) {
        super(repository);
    }
    
    @Override
    public Wand update(Wand entity) {
        return null;
    }
}
