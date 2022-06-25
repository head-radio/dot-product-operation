package com.dotproduct.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DotProductRequest implements Serializable {

    long[] arrayA;
    long[] arrayB;

}
