package com.tghelper.globalosin.application.api.address;

import com.tghelper.globalosin.application.api.BaseController;
import com.tghelper.globalosin.application.api.JsonResponse;
import com.tghelper.globalosin.application.service.address.ProvinceCityService;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by infamouSs on 1/27/18.
 */
@RestController
public class ProvinceCityController extends BaseController {
    
    public static final String TAG = ProvinceCityController.class.getSimpleName();
    
    public static final String BASE_URL = "/province";
    
    @Autowired
    private ProvinceCityService mProvinceCityService;
    
    @RequestMapping(value = "/province/health-check", method = RequestMethod.GET)
    public ProvinceCity healthCheck() {
        throw new EntityDoesNotExistException("Province city not exists");
    }
    
    @RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET)
    public JsonResponse getProvinceCityById(@PathVariable("id") String id) {
        try {
            ProvinceCity provinceCity = mProvinceCityService.findById(id);
            
            return new JsonResponse.Builder<ProvinceCity>()
                      .setData(provinceCity)
                      .setHttpStatus(HttpStatus.OK)
                      .isSuccess(true)
                      .build();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @RequestMapping(value = BASE_URL, method = RequestMethod.GET)
    public JsonResponse getProvinceCityByName(@RequestParam("name") String name) {
        try {
            ProvinceCity provinceCity = mProvinceCityService.findProvinceCityByName(name);
            return new JsonResponse.Builder<ProvinceCity>()
                      .setData(provinceCity)
                      .setHttpStatus(HttpStatus.OK)
                      .isSuccess(true)
                      .build();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @RequestMapping(value = BASE_URL)
    public ProvinceCity testPost(@RequestBody ProvinceCity provinceCity) {
        System.out.println(provinceCity);
        return provinceCity;
    }
}
