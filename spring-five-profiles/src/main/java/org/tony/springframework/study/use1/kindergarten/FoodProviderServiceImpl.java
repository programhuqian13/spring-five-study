package org.tony.springframework.study.use1.kindergarten;

import org.tony.springframework.study.use1.Food;
import org.tony.springframework.study.use1.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.use1.kindergarten
 */
public class FoodProviderServiceImpl implements FoodProviderService{

    @Override
    public List<Food> providerLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("mike"));
        lunchSet.add(new Food("Biscuits"));
        return lunchSet;
    }
}
