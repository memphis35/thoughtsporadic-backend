package com.thoughtsporadic.backend.controller;

import com.thoughtsporadic.backend.model.BlogPost;
import io.micronaut.http.HttpResponse;

import java.util.Collection;

public interface BlogController {

    HttpResponse<Collection<BlogPost>> findAllPosts();

    HttpResponse<Collection<BlogPost>> findAllPostsByTag(String tag);

    HttpResponse<Collection<String>> findAllTags();
}
