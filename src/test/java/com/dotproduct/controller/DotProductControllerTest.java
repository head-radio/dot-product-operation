package com.dotproduct.controller;

import com.google.gson.Gson;
import com.dotproduct.IDotProductService;
import com.dotproduct.model.DotProductListRequest;
import com.dotproduct.model.DotProductRequest;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.dotproduct.util.WebURLSUtil.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DotProductController.class)
@AutoConfigureMockMvc
@Log4j2
public class DotProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDotProductService iDotProductService;

    @Test
    public void dotProductTest() throws Exception {

        DotProductRequest dotProductRequest = new DotProductRequest();
        dotProductRequest.setArrayA(new long[]{1, 2, 3});
        dotProductRequest.setArrayB(new long[]{1, 2, 3});

        Gson gson = new Gson();
        log.info(gson.toJson(dotProductRequest));

        when(iDotProductService.dotProduct(new long[]{1, 2, 3}, new long[]{1, 2, 3})).thenReturn(14L);
        mockMvc.perform(post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(dotProductRequest)))
                .andExpect(status().isOk());

    }

}