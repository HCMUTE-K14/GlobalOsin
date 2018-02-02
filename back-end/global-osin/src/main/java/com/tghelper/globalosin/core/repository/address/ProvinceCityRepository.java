package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/23/18.
 */
@Repository
public interface ProvinceCityRepository extends JpaRepository<ProvinceCity, String> {
    
    List<ProvinceCity> findProvinceCitiesByNameContainingIgnoreCase(String name);
}
