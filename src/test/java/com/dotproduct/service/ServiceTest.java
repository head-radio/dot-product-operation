package com.dotproduct.service;

import com.dotproduct.exception.BadRequestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    DotProductService service;

    @Test
    public void dotProductTest() {
        long result = service.dotProduct(new long[]{1, 2, 3}, new long[]{1, 2, 3});
        assertEquals(14, result);
    }

    @Test(expected = BadRequestException.class)
    public void dotProductTest_exception1() {
        service.dotProduct(new long[]{1, 2, 3}, new long[]{1, 2});
    }

    @Test(expected = BadRequestException.class)
    public void dotProductTest_exception2() {
        service.dotProduct(null, new long[]{1, 2});
    }

    @Test
    public void dotProductListTest() {
        List<long[]> list = new ArrayList<>();
        list.add(new long[]{1, 2, 3});
        list.add(new long[]{1, 2, 3});
        long result = service.dotProduct(list);
        assertEquals(14, result);
    }

    @Test(expected = BadRequestException.class)
    public void dotProductListTest_exception1() {
        List<long[]> list = new ArrayList<>();
        long result = service.dotProduct(list);
    }

    @Test(expected = BadRequestException.class)
    public void dotProductListTest_exception2() {
        List<long[]> list = new ArrayList<>();
        list.add(new long[]{1, 2, 3});
        long result = service.dotProduct(list);
    }

    @Test(expected = BadRequestException.class)
    public void dotProductListTest_exception3() {
        List<long[]> list = new ArrayList<>();
        list.add(new long[]{1, 2, 3});
        list.add(new long[]{1, 2, 3, 4});
        long result = service.dotProduct(list);
    }

}