package com.kdt.responsemodel.exception;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class InputRestriction {
    private final Map<String, String> inputRestriction;

    public InputRestriction() {
        this.inputRestriction = new HashMap<>();
        this.inputRestriction.put("maxGrade", "6");
    }
}
