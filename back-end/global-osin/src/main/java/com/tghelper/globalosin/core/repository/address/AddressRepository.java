package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/23/18.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    
    @Query(value = "SELECT tbl_address.* FROM tbl_address, tbl_province_city " +
                   "WHERE province_city_id = tbl_province_city.id " +
                   "AND LOWER(tbl_province_city.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
    List<Address> findAddressByProvinceCityNameLike(@Param("name") String name);
    
    @Query(value = "SELECT tbl_address.* FROM tbl_address, tbl_district " +
                   "WHERE district_id = tbl_district.id " +
                   "AND LOWER(tbl_district.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
    List<Address> findAddressByDistrictNameLike(@Param("name") String name);
    
    @Query(value = "SELECT tbl_address.* FROM tbl_address, tbl_wand " +
                   "WHERE wand_id = tbl_wand.id " +
                   "AND LOWER(tbl_wand.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
    List<Address> findAddressByWandNameLike(@Param("name") String name);
    
    @Query(value = "SELECT tbl_address.* FROM tbl_address, tbl_street " +
                   "WHERE street_id = tbl_street.id " +
                   "AND LOWER(tbl_street.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
    List<Address> findAddressByStreetNameLike(@Param("name") String name);
    
    List<Address> findAddressByNameContainingIgnoreCase(String name);
    
}
