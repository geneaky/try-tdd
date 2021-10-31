package com.example.atddorder.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.atddorder.application.PendingOrderRequest;
import com.example.atddorder.application.PendingOrderResonse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderApiIntegrationTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @DisplayName("createPendingOrderTest")
  public void createPendingOrderTest() throws Exception {
    //given

    //when
    Long productid = 1l;
    int quantity = 2;
    PendingOrderRequest request = PendingOrderRequest.of(productid, quantity);
    MockHttpServletResponse response = mockMvc.perform(post("/orders/pendingOrder")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andReturn().getResponse();

    //then
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    PendingOrderResonse pendingOrderResonse = objectMapper.readValue(response.getContentAsString(),
        PendingOrderResonse.class);
    assertThat(pendingOrderResonse.getId()).isGreaterThan(0);
  }

}
