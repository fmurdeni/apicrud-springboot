package com.example.juniorprogrammer.apicrud.services;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.entities.CarImage;
import com.example.juniorprogrammer.apicrud.repositories.CarImageRepository;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import com.example.juniorprogrammer.apicrud.wrappers.CarImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarImageRepository carImageRepository;
    @Override
    public CarEntity addCar(CarEntity param) {
        return carRepository.save(param);
    }

    @Override
    public List<CarEntity> getallCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getByID(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param) {
        // Make sure car is existing
        CarEntity findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setColor(param.getColor());
        findCar.setNumber(param.getNumber());
        findCar.setType(param.getType());

        return carRepository.save(findCar);
    }

    @Override
    public List<CarEntity> deleteCar(int id) {
        CarEntity findCar = carRepository.findById(id).get();

        carRepository.deleteById(findCar.getId());
        return carRepository.findAll();
    }

    @Override
    public CarImage upload(CarImageWrapper carImageWrapper) {
        CarImage carImage = new CarImage();
        carImage.setCar(carRepository.findById(carImageWrapper.getCarId()).get());
        carImage.setContentType(carImageWrapper.getContentType());
        carImage.setBase64(carImageWrapper.getBase64());

        return carImageRepository.save(carImage);
    }


}
