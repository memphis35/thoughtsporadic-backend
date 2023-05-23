package com.thoughtsporadic.backend.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface BlogPost {

    @JsonGetter
    Long id();

    @JsonGetter
    String address();

    @JsonGetter
    String title();

    @JsonGetter("image")
    String imageUrl();

    @JsonGetter
    String text();
}
