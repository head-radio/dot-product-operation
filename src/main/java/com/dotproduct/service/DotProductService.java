package com.dotproduct.service;

import com.dotproduct.IDotProductService;
import com.dotproduct.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;


@org.springframework.stereotype.Service
@Log4j2
public class DotProductService implements IDotProductService {

    /**
     * calculate dot product between 2 array
     *
     * @param a array1
     * @param b array2
     * @return dotProduct result
     */
    @Override
    public long dotProduct(long[] a, long[] b) {

        if (a == null || b == null) {
            throw new BadRequestException("invalid input data");
        }

        if (a.length != b.length) {
            throw new BadRequestException("invalid length data");
        }

        return IntStream.range(0, a.length).mapToLong(i -> a[i] * b[i]).sum();

    }

    /**
     * calculate dot product starting a inputList of arrays of the same length
     * @param inputList of arrays
     * @return dot product result
     */
    @Override
    public long dotProduct(List<long[]> inputList) {

        // validate length of input
        if (inputList.size() < 2) {
            throw new BadRequestException("invalid length data");
        }

        // the arrays must have the same length
        int size = inputList.get(0).length;
        for (int i = 1; i < inputList.size(); i++) {
            if (size != inputList.get(i).length) {
                throw new BadRequestException("invalid length data");
            }
        }

        // calculate dot product
        AtomicLong dotProductResult = new AtomicLong(0);
        IntStream.range(0, size).forEach(i -> {
            AtomicLong tempValue = new AtomicLong(1);
            inputList.forEach(j -> {
                tempValue.set(tempValue.get() * j[i]);
            });
            dotProductResult.set(dotProductResult.get() + tempValue.get());
        });

        return dotProductResult.get();

    }

}
