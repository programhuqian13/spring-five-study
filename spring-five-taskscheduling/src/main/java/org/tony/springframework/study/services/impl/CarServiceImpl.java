package org.tony.springframework.study.services.impl;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tony.springframework.study.DataSourceConfig;
import org.tony.springframework.study.entity.Car;
import org.tony.springframework.study.repo.CarRepository;
import org.tony.springframework.study.services.CarService;

import java.time.Year;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    public boolean done;

    @Autowired
    private CarRepository carRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void updateCarAgeJob() {
        List<Car> cars = findAll();

        DateTime currentDate = DateTime.now();
        LOGGER.info("cas age update job started");

        cars.stream().forEach(car -> {
            int age = Years.yearsBetween(car.getManufactureDate(),currentDate).getYears();
            car.setAge(age);
            save(car);
            LOGGER.info("car age update ---> {}",car);
        });
        LOGGER.info("Car age update job completed successfully");
        done = true;
    }

    @Override
    public boolean isDone() {
        return done;
    }
}
