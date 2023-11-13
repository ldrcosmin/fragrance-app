package com.fragranceapp.fragranceapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String info;
    private double value;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Long> content;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;

}
