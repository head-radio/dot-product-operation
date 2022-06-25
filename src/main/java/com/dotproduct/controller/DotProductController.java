package com.dotproduct.controller;

import com.dotproduct.IDotProductService;
import com.dotproduct.model.DotProductListRequest;
import com.dotproduct.model.DotProductRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.dotproduct.util.WebURLSUtil.*;

@RestController
@RequestMapping(BASE_PATH)
public class DotProductController {

    @Autowired
    private IDotProductService iDotProductService;

    @PostMapping
    public ResponseEntity<Long> dtoProduct(@RequestBody DotProductRequest dotProductRequest) {
        return ResponseEntity.ok(iDotProductService.dotProduct(dotProductRequest.getArrayA(), dotProductRequest.getArrayB()));
    }

}