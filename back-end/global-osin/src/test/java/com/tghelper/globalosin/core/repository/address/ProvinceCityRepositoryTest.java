package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.core.entity.address.Street;
import com.tghelper.globalosin.core.entity.address.Wand;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
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
        ProvinceCity provinceCity = createProvinceData("Tp Ho Chi Minh");
        mProvinceCityRepository.save(provinceCity);
    }
    
    private ProvinceCity createProvinceData(String name) {
        ProvinceCity provinceCity = new ProvinceCity(name);
        
        District district = new District("Quan 1");
        District district1 = new District("Quan 2");
        Wand wand = new Wand("Phuong 1");
        wand.addStreet(new Street("Street 1"));
        wand.addStreet(new Street("Street 2"));
        district.addWand(wand);
        district.addWand(new Wand("Phuong 2"));
        
        provinceCity.addDistrict(district1);
        provinceCity.addDistrict(district);
        
        return provinceCity;
    }
    
    @Test
    public void testSaveProvinceCity() {
        ProvinceCity provinceCity = createProvinceData("Ho Chi Minh City");
        mProvinceCityRepository.save(provinceCity);
        List<ProvinceCity> lists = mProvinceCityRepository
                  .findProvinceCitiesByNameContainingIgnoreCase("Ho Chi Minh");
        
        System.out.println(lists);
        Assert.assertNotNull(lists);
    }
    
    @Test
    public void testSaveProvinceCityWithNameEmpty() {
        try {
            ProvinceCity provinceCity = createProvinceData("");
            mProvinceCityRepository.save(provinceCity);
            
            Assert.assertNotNull(mProvinceCityRepository.findAll());
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("Name is required", ex.getMessage());
        }
    }
    
    @Test
    public void testSaveProvinceCityWithNameNull() {
        try {
            ProvinceCity provinceCity = new ProvinceCity();
            mProvinceCityRepository.save(provinceCity);
            
            Assert.assertNotNull(mProvinceCityRepository.findAll());
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("Name is required", ex.getMessage());
        } catch (ConstraintViolationException | DataIntegrityViolationException ex) {
            Set<ConstraintViolation<?>> errors = ((ConstraintViolationException) ex)
                      .getConstraintViolations();
            for (ConstraintViolation<?> i : errors) {
                System.out.println(i);
            }
        }
    }
    
    @Test
    public void testGetProvinceCityByName() {
        ProvinceCity provinceCity1 = createProvinceData("Ho Chi Minh City");
        mProvinceCityRepository.save(provinceCity1);
        
        List<ProvinceCity> provinceCity = mProvinceCityRepository
                  .findProvinceCitiesByNameContainingIgnoreCase("Ho Chi Minh City");
        System.out.println(provinceCity);
        Assert.assertNotNull(provinceCity);
    }
    
    @Test
    public void testUpdateProvinceCity() {
        ProvinceCity provinceCity = createProvinceData("Ho Chi Minh city");
        mProvinceCityRepository.save(provinceCity);
        
        ProvinceCity provinceCityNeedToUpdate = mProvinceCityRepository
                  .findAll().get(0);
        
        System.out.println(provinceCityNeedToUpdate.getDistricts());
        
        provinceCityNeedToUpdate.setName("Ha Noi City");
        
        mProvinceCityRepository.save(provinceCityNeedToUpdate);
        
        ProvinceCity hanoiProvince = mProvinceCityRepository
                  .findProvinceCitiesByNameContainingIgnoreCase("Ha Noi City").get(0);
        
        System.out.println(hanoiProvince.getDistricts());
        
        Assert.assertNotNull(hanoiProvince);
    }
    
    @Test
    public void testDeleteProvinceCity() {
        ProvinceCity provinceCity = createProvinceData("Ha Noi City");
        mProvinceCityRepository.save(provinceCity);
        
        mProvinceCityRepository.deleteAll();
    }
    
    
    @After
    public void clear() {
    
    }
    
}