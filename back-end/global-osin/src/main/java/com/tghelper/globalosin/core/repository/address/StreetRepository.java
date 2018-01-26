package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/24/18.
 */
@Repository
public interface StreetRepository extends JpaRepository<Street, String> {
    
}
