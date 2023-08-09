package com.fragranceapp.fragranceapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderDTO {

    private String info;
    private double value;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Long> content;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long customerId;

    public OrderDTO() {

    }

    public OrderDTO(String info, double value, List<Long> content, Long customerId) {
        this.info = info;
        this.value = value;
        this.content = content;
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<Long> getContent() {
        return content;
    }

    public void setContent(List<Long> content) {
        this.content = content;
    }
}
