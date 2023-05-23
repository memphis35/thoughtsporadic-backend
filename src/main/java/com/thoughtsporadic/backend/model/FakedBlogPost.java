package com.thoughtsporadic.backend.model;

public class FakedBlogPost implements BlogPost {

    private final Long id;
    private final String address;
    private final String title;
    private final String imageUrl;
    private final String text;

    public FakedBlogPost(Long id, String address, String title, String imageUrl, String text) {
        this.id = id;
        this.address = address;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
    }

    @Override
    public Long id() {
        return this.id;
    }

    @Override
    public String address() {
        return this.address;
    }

    @Override
    public String title() {
        return this.title;
    }

    @Override
    public String imageUrl() {
        return this.imageUrl;
    }

    @Override
    public String text() {
        return this.text;
    }
}
