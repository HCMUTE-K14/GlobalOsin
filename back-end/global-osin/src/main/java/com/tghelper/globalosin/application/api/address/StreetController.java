package com.tghelper.globalosin.application.api.address;

import com.tghelper.globalosin.application.api.AbstractApiController;
import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.application.service.address.SearchType;
import com.tghelper.globalosin.application.service.address.StreetService;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.entity.address.Street;
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
public class StreetController extends AbstractApiController {
    
    public static final String TAG = StreetController.class.getSimpleName();
    
    public static final String BASE_URL = "/streets";
    
    private final StreetService mStreetService;
    
    @Autowired
    public StreetController(StreetService streetService) {
        this.mStreetService = streetService;
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getStreetById(@PathVariable("id") String id) {
        LOGGER.info("[INFO] GET STREET BY ID:" + id);
        
        Street street = mStreetService.findById(id);
        
        return new JsonResponse.Builder<Street>()
                  .setData(street)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.GET, params = {"getBy", "value"})
    @ResponseBody
    public JsonResponse getStreetByType(@RequestParam("getBy") String field,
              @RequestParam("value") String value) {
        LOGGER.info("[INFO] GET STREET BY TYPE");
        
        SearchType searchType;
        switch (field) {
            case "wand":
            case "wand_name":
                searchType = SearchType.FOREIGN_NAME_TYPE;
                break;
            case "wand_id":
                searchType = SearchType.FOREIGN_ID_TYPE;
                break;
            case "name":
                searchType = SearchType.NAME_TYPE;
                break;
            default:
                throw new BadRequestParamException(
                          "Accept 2 param (getBy/value). Please call request again");
        }
        
        List<Street> streets = mStreetService.findStreetByType(searchType, value);
        
        return new JsonResponse.Builder<List<Street>>()
                  .setData(streets)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Street street) {
        LOGGER.info("[INFO] CREATE STREET");
        
        mStreetService.create(street);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.CREATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse update(@PathVariable("id") String id,
              @RequestBody Street street) {
        LOGGER.info("[INFO] UPDATE PROVINCE/CITY");
        
        if (!id.equals(street.getId())) {
            street.setId(id);
        }
        
        mStreetService.update(street);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.UPDATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse delete(@PathVariable("id") String id,
              @RequestBody Street street) {
        LOGGER.info("[INFO] DELETE PROVINCE/CITY");
        
        if (!id.equals(street.getId())) {
            street.setId(id);
        }
        
        mStreetService.delete(street);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
}
