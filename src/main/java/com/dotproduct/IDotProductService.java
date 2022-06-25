package com.dotproduct;

import java.util.List;

public interface IDotProductService {

    long dotProduct(long[] a, long[] b);

    long dotProduct(List<long[]> inputList);
    
}
