package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.core.entity.address.Wand;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by infamouSs on 1/30/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DistrictRepositoryTest {
    
    @Autowired
    ProvinceCityRepository mProvinceCityRepository;
    @Autowired
    DistrictRepository mDistrictRepository;
    
    private ProvinceCity createProvinceData(String name) {
        ProvinceCity provinceCity = new ProvinceCity(name);
        
        District district = new District("Quan 1");
        District district1 = new District("Quan 2");
        
        provinceCity.addDistrict(district1);
        provinceCity.addDistrict(district);
        
        return provinceCity;
    }
    
    @Before
    public void init() {
    
    }
    
    @Test
    public void testSaveDistrict() {
        District district = new District("QUAN THU DUC");
        
        district.addWand(new Wand("Binh Tho"));
        district.addWand(new Wand("Linh Chieu"));
        
        mDistrictRepository.save(district);
        
        System.out.println(district.getId());
        System.out.println(mDistrictRepository.findAll());
    }
    
    @Test
    public void testFindDistrictByProvinceCityName() {
        ProvinceCity provinceCity = createProvinceData("Tp Ho Chi Minh");
        
        mProvinceCityRepository.save(provinceCity);
        
        List<District> lists = mDistrictRepository.findDistrictsByProvinceCityNameLike("Tp");
        
        System.out.println(lists);
    }
}