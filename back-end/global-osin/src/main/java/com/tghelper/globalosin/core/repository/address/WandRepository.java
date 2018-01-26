package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.Wand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/24/18.
 */
@Repository
public interface WandRepository extends JpaRepository<Wand, String> {
    
}
