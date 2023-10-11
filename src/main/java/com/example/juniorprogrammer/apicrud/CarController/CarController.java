package com.example.juniorprogrammer.apicrud.CarController;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.entities.CarImage;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import com.example.juniorprogrammer.apicrud.response.CommonResponse;
import com.example.juniorprogrammer.apicrud.response.CommonResponseGenerator;
import com.example.juniorprogrammer.apicrud.services.CarService;
import com.example.juniorprogrammer.apicrud.wrappers.CarImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {



    @Autowired
    CarService carService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkAPI(){
        return commonResponseGenerator.successResponse( "hello Kakak", "Success access the API" );
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param){
        try {
            CarEntity car = carService.addCar(param);
            return commonResponseGenerator.successResponse(car,"Success add new car");

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar(){
        try {
            List<CarEntity> carList = carService.getallCar();
            return commonResponseGenerator.successResponse(carList, "Showing all cars");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }


    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int  id){
        try {
            CarEntity car = carService.getByID(id);
            return commonResponseGenerator.successResponse(car, "Showing car "+car.getId());

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "updateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param){
        try {
            CarEntity car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car, "Success Updating car id: "+car.getId());

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage()+ " for id: "+param.getId());
        }
    }

    @DeleteMapping(value = "deleteCar")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id){
        try {

            carService.deleteCar(id);
            List<CarEntity> carList = carService.getallCar();
            return commonResponseGenerator.successResponse(carList, "Success deleting car id: "+id);
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage()+ " for id: "+id);
        }
    }

    @PostMapping(value = "upload-car")
    public CommonResponse<CarImage> upload(@RequestBody CarImageWrapper param){
        try {
            CarImage car = carService.upload(param);
            return commonResponseGenerator.successResponse(car, "Success uploading images");

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
