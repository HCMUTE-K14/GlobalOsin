package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/23/18.
 */
@Repository
public interface ProvinceCityRepository extends JpaRepository<ProvinceCity, String> {
    
    @Query(value = "SELECT * FROM tbl_province_city  where name = ?1", nativeQuery = true)
    ProvinceCity findProvinceCitiesByName(String name);
}
