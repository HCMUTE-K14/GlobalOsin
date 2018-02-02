package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.Street;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by infamouSs on 1/24/18.
 */
@Repository
public interface StreetRepository extends JpaRepository<Street, String> {
    
    @Query(value = "SELECT * FROM tbl_street WHERE wand_id = ?1", nativeQuery = true)
    List<Street> findStreetsByWandId(String wandId);
    
    @Query(value = "SELECT tbl_street.* FROM tbl_street, tbl_wand " +
                   "WHERE wand_id = tbl_wand.id " +
                   "AND LOWER(tbl_wand.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
    List<Street> findStreetsByWandNameLike(@Param("name") String name);
    
    List<Street> findStreetsByNameContainingIgnoreCase(String name);
}
