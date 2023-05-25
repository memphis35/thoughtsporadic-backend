package com.thoughtsporadic.backend.controller;

import com.thoughtsporadic.backend.model.BlogPost;
import com.thoughtsporadic.backend.model.FakedBlogPost;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Controller
public class BlogControllerImpl implements BlogController {

    private static final Logger log = LoggerFactory.getLogger(BlogControllerImpl.class);

    private final BlogPost post1 = new FakedBlogPost(
            100001L,
            "/var/thoughs/death_sentence_there_are_no_good_solutions",
            "Death sentence: there are no good solutions",
            "https://memphis35-jars.s3.amazonaws.com/death_sentence_there_are_no_good_solutions.png",
            """
                    POST ABOUT DEATH PENALTY
                    """);

    private final BlogPost post2 = new FakedBlogPost(100002L,
            "/var/thoughs/what_feminism_means_today",
            "What feminism means today",
            "https://memphis35-jars.s3.amazonaws.com/what_feminism_means_today.jpg",
            """
                     POST ABOUT FEMINISM
                    """);

    private final BlogPost post3 = new FakedBlogPost(100003L,
            "/var/thoughs/revenge_cheating_what_you_need_to_know",
            "Revenge Cheating: What You Need to Know",
            "https://memphis35-jars.s3.amazonaws.com/revenge_cheating.jpg",
            """
                    POST ABOUT RELATIONSHIPS
                    """);

    @Override
    @Get(value = "/posts", produces = {APPLICATION_JSON})
    public HttpResponse<Collection<BlogPost>> findAllPosts() {
        final Collection<BlogPost> posts = List.of(post1, post2, post3);
        log.info("Posts are retrieved");
        return HttpResponse.ok(posts);
    }

    @Override
    @Get(value = "/posts/tag/{tag}", produces = {APPLICATION_JSON})
    public HttpResponse<Collection<BlogPost>> findAllPostsByTag(@PathVariable String tag) {
        final Collection<BlogPost> posts = (tag.equals("feminism"))
                ? List.of(post2)
                : List.of(post1, post3);
        return HttpResponse.ok(posts);
    }

    @Override
    @Get(value = "/tags")
    public HttpResponse<Collection<String>> findAllTags() {
        return HttpResponse.ok(List.of("feminism", "ethic", "relationships"));
    }
}
