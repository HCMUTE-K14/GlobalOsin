package com.tghelper.globalosin.application.api.address;

import com.tghelper.globalosin.application.api.AbstractApiController;
import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.application.service.address.SearchType;
import com.tghelper.globalosin.application.service.address.DistrictService;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.entity.address.District;
import com.tghelper.globalosin.exception.BadRequestParamException;
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
public class DistrictController extends AbstractApiController {
    
    public static final String TAG = DistrictController.class.getSimpleName();
    
    public static final String BASE_URL = "/districts";
    
    private DistrictService mDistrictService;
    
    @Autowired
    public DistrictController(DistrictService districtService) {
        this.mDistrictService = districtService;
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getDistrictById(@PathVariable("id") String id) {
        LOGGER.info("[INFO] GET DISTRICT BY ID:" + id);
        District district = mDistrictService.findById(id);
        
        return new JsonResponse.Builder<District>()
                  .setData(district)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.GET, params = {"getBy", "value"})
    @ResponseBody
    public JsonResponse getDistrictByType(@RequestParam("getBy") String field,
              @RequestParam("value") String value) {
        LOGGER.info("[INFO] GET DISTRICT BY TYPE");
        
        SearchType searchType;
        switch (field) {
            case "province_city":
            case "province_city_name":
                searchType = SearchType.FOREIGN_NAME_TYPE;
                break;
            case "province_city_id":
                searchType = SearchType.FOREIGN_ID_TYPE;
                break;
            case "name":
                searchType = SearchType.NAME_TYPE;
                break;
            default:
                throw new BadRequestParamException(
                          "Accept 2 param (getBy/value). Please call request again");
        }
        
        List<District> districts = mDistrictService.findDistrictByType(searchType, value);
        
        return new JsonResponse.Builder<List<District>>()
                  .setData(districts)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody District district) {
        LOGGER.info("[INFO] CREATE DISTRICT");
        
        mDistrictService.create(district);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.CREATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse update(@PathVariable("id") String id,
              @RequestBody District district) {
        LOGGER.info("[INFO] UPDATE DISTRICT");
        
        if (!id.equals(district.getId())) {
            district.setId(id);
        }
        
        mDistrictService.update(district);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.UPDATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse delete(@PathVariable("id") String id,
              @RequestBody District district) {
        LOGGER.info("[INFO] DELETE DISTRICT");
        
        if (!id.equals(district.getId())) {
            district.setId(id);
        }
        
        mDistrictService.delete(district);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
}
