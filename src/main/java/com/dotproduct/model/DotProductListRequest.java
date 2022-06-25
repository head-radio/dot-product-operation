package com.dotproduct.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DotProductListRequest implements Serializable {

    List<long[]> list;

}
