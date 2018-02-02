package com.tghelper.globalosin.application.api.address;

import com.tghelper.globalosin.application.api.AbstractApiController;
import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.application.service.SearchType;
import com.tghelper.globalosin.application.service.address.WandService;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.entity.address.Wand;
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
public class WandController extends AbstractApiController {
    
    public static final String TAG = WandController.class.getSimpleName();
    
    public static final String BASE_URL = "/wands";
    
    private final WandService mWandService;
    
    @Autowired
    public WandController(WandService wandService) {
        this.mWandService = wandService;
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getWandById(@PathVariable("id") String id) {
        Wand wand = mWandService.findById(id);
        
        return new JsonResponse.Builder<Wand>()
                  .setData(wand)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.GET, params = {"getBy", "value"})
    @ResponseBody
    public JsonResponse getWandByType(@RequestParam("getBy") String field,
              @RequestParam("value") String value) {
        LOGGER.info("[INFO] GET WAND BY TYPE");
        
        SearchType searchType;
        switch (field) {
            case "district":
            case "district_name":
                searchType = SearchType.FOREIGN_NAME_TYPE;
                break;
            case "district_id":
                searchType = SearchType.FOREIGN_ID_TYPE;
                break;
            case "name":
                searchType = SearchType.NAME_TYPE;
                break;
            default:
                throw new BadRequestParamException(
                          "Accept 2 param (getBy/value). Please call request again");
        }
        
        List<Wand> wands = mWandService.findWandByType(searchType, value);
        
        return new JsonResponse.Builder<List<Wand>>()
                  .setData(wands)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Wand wand) {
        LOGGER.info("[INFO] CREATE WAND");
        
        mWandService.create(wand);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.CREATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse update(@PathVariable("id") String id,
              @RequestBody Wand wand) {
        LOGGER.info("[INFO] UPDATE WAND");
        
        if (!id.equals(wand.getId())) {
            wand.setId(id);
        }
        
        mWandService.update(wand);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.UPDATE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse delete(@PathVariable("id") String id,
              @RequestBody Wand wand) {
        LOGGER.info("[INFO] DELETE DISTRICT");
        
        if (!id.equals(wand.getId())) {
            wand.setId(id);
        }
        
        mWandService.delete(wand);
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
                  .setHttpStatus(HttpStatus.OK)
                  .isSuccess(true)
                  .build();
    }
}
