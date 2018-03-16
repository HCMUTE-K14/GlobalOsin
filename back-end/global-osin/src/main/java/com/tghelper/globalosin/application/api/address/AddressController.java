package com.tghelper.globalosin.application.api.address;

import com.tghelper.globalosin.application.api.AbstractApiController;
import com.tghelper.globalosin.application.model.AddressModel;
import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.application.service.address.SearchType;
import com.tghelper.globalosin.application.service.address.AddressService;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.entity.address.Address;
import com.tghelper.globalosin.core.repository.address.DistrictRepository;
import com.tghelper.globalosin.core.repository.address.ProvinceCityRepository;
import com.tghelper.globalosin.core.repository.address.StreetRepository;
import com.tghelper.globalosin.core.repository.address.WandRepository;
import com.tghelper.globalosin.exception.BadRequestParamException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by infamouSs on 1/29/18.
 */
@RestController
public class AddressController extends AbstractApiController {
    
    public static final String BASE_URL = "/addresses";
    private final AddressService mAddressService;
    private final StreetRepository mStreetRepository;
    
    private final WandRepository mWandRepository;
    
    private final DistrictRepository mDistrictRepository;
    
    private final ProvinceCityRepository mProvinceCityRepository;
    
    @Autowired
    public AddressController(AddressService mAddressService, StreetRepository mStreetRepository,
              WandRepository mWandRepository, DistrictRepository mDistrictRepository,
              ProvinceCityRepository mProvinceCityRepository) {
        this.mAddressService = mAddressService;
        this.mStreetRepository = mStreetRepository;
        this.mWandRepository = mWandRepository;
        this.mDistrictRepository = mDistrictRepository;
        this.mProvinceCityRepository = mProvinceCityRepository;
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAddressById(@PathVariable("id") String id) {
        LOGGER.info("[INFO] GET ADDRESS BY ID:" + id);
        
        Address address = mAddressService.findById(id);
        AddressModel addressModel = parseFromAddressEntity(address);
        
        return new JsonResponse.Builder<AddressModel>()
                  .setData(addressModel)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.GET, params = {"getBy", "value"})
    @ResponseBody
    public JsonResponse getDistrictByType(@RequestParam("getBy") String field,
              @RequestParam("value") String value) {
        LOGGER.info("[INFO] GET ADDRESS BY TYPE");
        
        SearchType searchType;
        switch (field) {
            case "province_city":
            case "province_city_name":
                searchType = SearchType.ADDRESS_PROVINCE_NAME;
                break;
            case "province_city_id":
                searchType = SearchType.ADDRESS_PROVINCE_ID;
                break;
            case "district":
            case "district_name":
                searchType = SearchType.ADDRESS_DISTRICT_NAME;
                break;
            case "district_id":
                searchType = SearchType.ADDRESS_DISTRICT_ID;
                break;
            case "wand":
            case "wand_name":
                searchType = SearchType.ADDRESS_WAND_NAME;
                break;
            case "wand_id":
                searchType = SearchType.ADDRESS_WAND_ID;
                break;
            case "street":
            case "street_name":
                searchType = SearchType.ADDRESS_STREET_NAME;
                break;
            case "street_id":
                searchType = SearchType.ADDRESS_STREET_ID;
                break;
            case "name":
                searchType = SearchType.NAME_TYPE;
                break;
            default:
                throw new BadRequestParamException(
                          "Accept 2 param (getBy/value). Please call request again");
        }
        
        List<Address> addresses = mAddressService.findAddressByType(searchType, value);
        List<AddressModel> addressModels = parseFromListAddressEntity(addresses);
        return new JsonResponse.Builder<List<AddressModel>>()
                  .setData(addressModels)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Address address) {
        LOGGER.info("[INFO] CREATE ADDRESS");
        
        mAddressService.create(address);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.CREATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse update(@PathVariable("id") String id,
              @RequestBody Address address) {
        LOGGER.info("[INFO] UPDATE ADDRESS");
        
        if (!id.equals(address.getId())) {
            address.setId(id);
        }
        
        mAddressService.update(address);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.UPDATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse delete(@PathVariable("id") String id,
              @RequestBody Address address) {
        LOGGER.info("[INFO] DELETE ADDRESS");
        
        if (!id.equals(address.getId())) {
            address.setId(id);
        }
        
        mAddressService.delete(address);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    public AddressModel parseFromAddressEntity(Address address) {
        AddressModel addressModel = new AddressModel();
        
        addressModel.setId(address.getId());
        addressModel.setLatitude(address.getLatitude());
        addressModel.setLongitude(address.getLongitude());
        addressModel.setStreet(
                  address.getStreet() == null ? ""
                            : mStreetRepository.getOne(address.getStreet()).getName());
        addressModel.setWand(address.getWand() == null ? ""
                  : mWandRepository.getOne(address.getWand()).getName());
        addressModel.setDistrict(
                  address.getDistrict() == null ? ""
                            : mDistrictRepository.getOne(address.getDistrict()).getName());
        addressModel.setProvince(
                  address.getProvinceCity() == null ? ""
                            : mProvinceCityRepository.getOne(address.getProvinceCity()).getName());
        
        return addressModel;
    }
    
    public List<AddressModel> parseFromListAddressEntity(List<Address> addressList) {
        List<AddressModel> addressModels = new ArrayList<>();
        
        for (Address address : addressList) {
            AddressModel addressModel = parseFromAddressEntity(address);
            addressModels.add(addressModel);
        }
        return addressModels;
    }
}
