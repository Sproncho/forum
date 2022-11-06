package com.dazna.forum.forum.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class PeriodDto {
    LocalDate dateFrom;
    LocalDate dateTo;
}
