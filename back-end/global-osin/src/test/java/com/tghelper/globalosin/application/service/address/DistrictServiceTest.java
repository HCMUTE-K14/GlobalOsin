package com.tghelper.globalosin.application.service.address;

import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.core.entity.address.Street;
import com.tghelper.globalosin.core.entity.address.Wand;
import javax.transaction.Transactional;
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
public class DistrictServiceTest {
    
    @Autowired
    ProvinceCityService mProvinceCityService;
    
    @Autowired
    DistrictService mDistrictService;
    
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
    public void test() {
        mProvinceCityService.create(createProvinceData("Da Nang"));
        System.out.println(mDistrictService
                  .findDistrictByType(SearchType.FOREIGN_NAME_TYPE, "Da Nang"));
        District district = mDistrictService
                  .findDistrictByType(SearchType.FOREIGN_NAME_TYPE, "Da Nang")
                  .get(0);
        System.out.println(district);
        District entity = mDistrictService
                  .findDistrictByType(SearchType.FOREIGN_NAME_TYPE, "Da Nang")
                  .get(1);
        entity.setName("1234098");
        
        mDistrictService.update(entity);
        System.out.println(mDistrictService.findDistrictByType(SearchType.NAME_TYPE, "1234098"));
    }
    
    @Test
    public void testUpdate() {
    
    }
}