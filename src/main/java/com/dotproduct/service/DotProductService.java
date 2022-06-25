package com.dotproduct.service;

import com.dotproduct.IDotProductService;
import com.dotproduct.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;

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

}
