package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by infamouSs on 1/23/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProvinceCityRepositoryTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProvinceCityRepositoryTest.class);
    
    @Autowired
    ProvinceCityRepository mProvinceCityRepository;
    
    @Before
    public void init() {
//        ProvinceCity provinceCity = createProvinceData();
//        mProvinceCityRepository.save(provinceCity);
    }
    
    private ProvinceCity createProvinceData() {
        ProvinceCity provinceCity = new ProvinceCity();
        
        District district = new District("Quan 1");
        District district1 = new District("Quan 2");
        
        provinceCity.addDistrict(district1);
        provinceCity.addDistrict(district);
        
        return provinceCity;
    }
    
    @Test
    public void testSaveProvinceCity() {
        ProvinceCity provinceCity = createProvinceData();
        mProvinceCityRepository.save(provinceCity);
        
        Assert.assertNotNull(mProvinceCityRepository.findAll());
    }
    
    @Test
    public void testGetProvinceCityByName() {
        ProvinceCity provinceCity1 = createProvinceData();
        mProvinceCityRepository.save(provinceCity1);
        
        ProvinceCity provinceCity = mProvinceCityRepository
                  .findProvinceCitiesByName("Ho Chi Minh City");
        System.out.println(provinceCity.getDistricts());
        Assert.assertNotNull(provinceCity);
    }
    
    @Test
    public void testUpdateProvinceCity() {
        ProvinceCity provinceCity = createProvinceData();
        mProvinceCityRepository.save(provinceCity);
        
        ProvinceCity provinceCityNeedToUpdate = mProvinceCityRepository
                  .findAll().get(0);
        
        provinceCityNeedToUpdate.setName("Ha Noi City");
        
        mProvinceCityRepository.save(provinceCityNeedToUpdate);
        
        ProvinceCity hanoiProvince = (ProvinceCity) mProvinceCityRepository
                  .findProvinceCitiesByName("Ha Noi City");
        
        Assert.assertNotNull(mProvinceCityRepository.findProvinceCitiesByName("Ha Noi City"));
    }
    
    @Test
    public void testDeleteProvinceCity() {
        ProvinceCity provinceCity = createProvinceData();
        mProvinceCityRepository.save(provinceCity);
        
        mProvinceCityRepository.deleteAll();
    }
    
    
    @After
    public void clear() {
    
    }
    
}