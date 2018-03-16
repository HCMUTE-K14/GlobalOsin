package com.tghelper.globalosin.core.repository.address;

import com.tghelper.globalosin.core.entity.address.Address;
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
public class AddressRepositoryTest {
    
    @Autowired
    ProvinceCityRepository mProvinceCityRepository;
    
    @Autowired
    StreetRepository mStreetRepository;
    
    @Autowired
    WandRepository mWandRepository;
    
    @Autowired
    DistrictRepository mDistrictRepository;
    
    @Autowired
    AddressRepository mAddressRepository;
    
    @Test
    public void test() {
        ProvinceCity province = new ProvinceCity();
        province.setName("PROVINCE");
        
        District district = new District();
        district.setName("DISTRICT");
        
        Wand wand = new Wand();
        wand.setName("WAND");
        
        Street street = new Street("STREET");
        
        wand.addStreet(street);
        district.addWand(wand);
        province.addDistrict(district);
        
        mProvinceCityRepository.save(province);
        
        Address address = new Address();
        address.setFullAddress("FULL ADDRESS");
        address.setStreet(street.getId());
        address.setWand(wand.getId());
        address.setDistrict(district.getId());
        address.setProvinceCity(province.getId());
        
        mAddressRepository.save(address);
        
        System.out.println("PROVINCEID " + province.getId());
        
        System.out.println(
                  mAddressRepository.findAddressByFullAddressContainingIgnoreCase("FULL ADDRESS"));
        System.out.println(
                  mProvinceCityRepository.findProvinceCitiesByNameContainingIgnoreCase("PROVINCE")
                            .get(0).getId());
    }
}