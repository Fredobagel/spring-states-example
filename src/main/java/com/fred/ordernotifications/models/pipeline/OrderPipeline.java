package com.fred.ordernotifications.models.pipeline;

import com.fred.ordernotifications.models.steps.StepBase;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class OrderPipeline {
    public OrderPipeline() {
        this.id = UUID.randomUUID();
    }

    private UUID id;

    private List<StepBase> steps = new ArrayList<>();
}
