package com.tghelper.globalosin.application.service.address;

import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by infamouSs on 1/27/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProvinceCityServiceTest {
    
    @Autowired
    ProvinceCityService mProvinceCityService;
    
    private ProvinceCity createProvinceData() {
        ProvinceCity provinceCity = new ProvinceCity("");
        
        District district = new District("Quan 1");
        District district1 = new District("Quan 2");
        
        provinceCity.setDistricts(null);
        
        return provinceCity;
    }
    
    @Before
    public void init() {
    
    }
    
    
    @Test
    public void testSaveProvinceCity() {
        ProvinceCity provinceCity = createProvinceData();
        
        mProvinceCityService.create(provinceCity);
        
        org.junit.Assert
                  .assertNotNull(mProvinceCityService.findProvinceCityByName("Tp Ho Chi Minh"));
    }
}