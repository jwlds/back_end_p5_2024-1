package com.puccampinas.back_end_pi5.dtos;

public record ApiResponse<T>(int  status, String message, T payload) {
}
