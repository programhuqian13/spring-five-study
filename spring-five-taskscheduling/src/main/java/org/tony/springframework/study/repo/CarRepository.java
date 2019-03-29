package org.tony.springframework.study.repo;

import org.springframework.data.repository.CrudRepository;
import org.tony.springframework.study.entity.Car;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.repo
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
