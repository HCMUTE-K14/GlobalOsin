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
        ProvinceCity provinceCity = new ProvinceCity("7890");
        
        District district = new District("Quan 1");
        District district1 = new District("Quan 2");
        
        provinceCity.addDistrict(district);
        provinceCity.addDistrict(district1);
        
        return provinceCity;
    }
    
    @Before
    public void init() {
    }
    
    
    @Test
    public void testSaveProvinceCity() {
        try {
            
            ProvinceCity provinceCity = mProvinceCityService.findProvinceCityByName("123456");
            
            ProvinceCity newProvince = createProvinceData();
            newProvince.setId(provinceCity.getId());
            
            mProvinceCityService.update(newProvince);
            
            System.out.println(mProvinceCityService.findAll().get(0).getDistricts());
        } catch (Exception ex) {
            throw ex;
        }
        
    }
}