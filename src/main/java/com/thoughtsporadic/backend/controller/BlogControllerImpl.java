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
            "https://memphis35-jars.s3.amazonaws.com/images/death_sentence_there_are_no_good_solutions.png",
            """
                    The American Civil Liberties Union believes the death penalty inherently violates the constitutional ban against cruel and unusual punishment and the guarantees of due process of law and of equal protection under the law. Furthermore, we believe that the state should not give itself the right to kill human beings – especially when it kills with premeditation and ceremony, in the name of the law or in the name of its people, and when it does so in an arbitrary and discriminatory fashion.
                    Capital punishment is an intolerable denial of civil liberties and is inconsistent with the fundamental values of our democratic system.  The death penalty is uncivilized in theory and unfair and inequitable in practice.  Through litigation, legislation, and advocacy against this barbaric and brutal institution, we strive to prevent executions and seek the abolition of capital punishment.
                    """);

    private final BlogPost post2 = new FakedBlogPost(100002L,
            "/var/thoughs/what_feminism_means_today",
            "What feminism means today",
            "https://memphis35-jars.s3.amazonaws.com/images/what_feminism_means_today.jpg",
            """
                    There have been many extraordinary women who have played an important role in local or world history, but not all of these have necessarily been advocates of women’s issues. The women’s movement is made up of women and men who work and fight to achieve gender equality and to improve the lives of women as a social group. In most societies, women were traditionally confined to the home as daughters, wives and mothers, and we are often only aware of women in history because of their relation to famous men. Of course many women throughout history did in fact play an important role in cultural and political life, but they tend to be invisible. An organised women’s movement only really started in the 19th century, even though women activists and the struggle for equality have always been part of all human societies.
                    """);

    private final BlogPost post3 = new FakedBlogPost(100003L,
            "/var/thoughs/revenge_cheating_what_you_need_to_know",
            "Revenge Cheating: What You Need to Know",
            "https://memphis35-jars.s3.amazonaws.com/images/revenge_cheating.jpg",
            """
                    Revenge cheating is a type of infidelity committed in retaliation by a person who has been cheated on, in hopes to get revenge on the partner who cheated first. Being cheated on is very painful, so the urge to seek revenge and get justice can help people justify the act of cheating back to teach their partner a lesson.
                    As with all types of infidelity, revenge cheating can be a physical or emotional affair, and can happen in person or online. Revenge cheating in a person can include one-on-one meet-ups where there is physical contact or intense emotional intimacy that mimics a relationship, whereas online can include messaging an ex, sexting, flirting with others, or sharing explicit photos.
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
