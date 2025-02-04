package com.kdt.responsemodel.response;

import lombok.Getter;

@Getter
public class Metadata {
    private final int resultCount;

    public Metadata(int resultCount) {
        this.resultCount = resultCount;
    }
}
