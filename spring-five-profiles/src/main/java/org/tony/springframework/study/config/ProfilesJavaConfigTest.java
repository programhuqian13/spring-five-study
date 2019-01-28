package org.tony.springframework.study.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tony.springframework.study.use1.FoodProviderService;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HighSchoolConfig.class,KindergartenConfig.class})
@ActiveProfiles("kindergarten")
public class ProfilesJavaConfigTest {

    @Autowired
    private FoodProviderService foodProviderService;

    @Test
    public void testProvider(){
        System.out.println("Test......");
        assertTrue(foodProviderService.providerLunchSet() != null);
        assertFalse(foodProviderService.providerLunchSet().isEmpty());
        assertEquals(2,foodProviderService.providerLunchSet().size());
    }

}
