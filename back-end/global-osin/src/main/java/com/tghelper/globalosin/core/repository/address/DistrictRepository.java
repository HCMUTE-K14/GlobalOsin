package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.District;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/23/18.
 */
@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
    
    @Query(value = "SELECT * FROM tbl_district WHERE province_city_id = ?1", nativeQuery = true)
    List<District> findDistrictsByProvinceCityId(String provinceCityId);
    
    @Query(value = "SELECT tbl_district.* FROM tbl_district, tbl_province_city " +
                   "WHERE province_city_id = tbl_province_city.id " +
                   "AND LOWER(tbl_province_city.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
    List<District> findDistrictsByProvinceCityNameLike(@Param("name") String name);
    
    List<District> findDistrictsByNameContainingIgnoreCase(String name);
}
