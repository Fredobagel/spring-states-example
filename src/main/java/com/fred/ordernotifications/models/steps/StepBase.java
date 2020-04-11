package com.fred.ordernotifications.models.steps;

import lombok.Data;

@Data
public class StepBase {
    private String eventId;

    private Long stepNumber;
}
