package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.Wand;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/24/18.
 */
@Repository
public interface WandRepository extends JpaRepository<Wand, String> {
    
    @Query(value = "SELECT * FROM tbl_wand WHERE district_id = ?1", nativeQuery = true)
    List<Wand> findWandsByDistrictId(String districtId);
    
    @Query(value = "SELECT tbl_wand.* FROM tbl_wand, tbl_district " +
                   "WHERE district_id = tbl_district.id " +
                   "AND LOWER(tbl_district.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
    List<Wand> findWandsByDistrictNameLike(@Param("name") String name);
    
    List<Wand> findWandsByNameContainingIgnoreCase(String name);
}
