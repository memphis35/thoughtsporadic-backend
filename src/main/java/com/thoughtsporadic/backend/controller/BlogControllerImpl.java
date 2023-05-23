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
            "https://ejusa.org/wp-content/uploads/Death-Penalty-Movement-blog.png",
            """
                    The prospect of a death penalty repeal has never gotten as far along in Ohio as it has this year. So it seemed like a great time to bring together Jennifer Pryor, Director of Organizing & Community Outreach at Ohioans to Stop Executions, and Sarah Craft, Death Penalty Program Director at EJUSA. They discussed the evolution of the death penalty movement over the past 17 years.
                    To put it plainly, a lot has changed. In 2005, leadership that supported executions. Today, national and local leaders vocally condemn capital punishment. Executions have decreased to just over a third of what the numbers were in the past.
                    National support for repealing the death penalty has grown every year. Many more people are being vocal about being against executions fundamentally. Historically, a call for innocence or obvious racial bias has dictated the wave of support.
                    There’s a clearer understanding that racial disparities in the death penalty run throughout the criminal legal system. Visit our YouTube Channel to listen to their conversation.
                    """);

    private final BlogPost post2 = new FakedBlogPost(100002L,
            "/var/thoughs/what_feminism_means_today",
            "What feminism means today",
            "https://www.dictionary.com/e/wp-content/uploads/2021/03/20210301_feminism_1000x700-790x310.jpg",
            """
                     Are you a feminist? “Yes,” some readily answer. Others grimace and deny any involvement with that “bra-burning, man-hating” movement.
                    To Cynthia de las Fuentes, PhD, past-president of APA's Div. 35 (Society for the Psychology of Women), such negative perceptions derive from media distortion-not the movement's mission of equality for the sexes at work and at home. What's more, many young women--and men--don't realize that equality has yet to be achieved, she says.
                    She laments the division's relative absence of men, minorities and members younger than 30--the last of which is a trend across all APA divisions.
                    "We've had trouble communicating feminism's continuing relevance to young people and people of color," says de las Fuentes, an associate professor at San Antonio-based Our Lady of the Lake University. "Most current Div. 35 members were active in women's rights in the '70s, and they still are."
                    """);

    private final BlogPost post3 = new FakedBlogPost(100003L,
            "/var/thoughs/revenge_cheating_what_you_need_to_know",
            "Revenge Cheating: What You Need to Know",
            "https://thepleasantrelationship.com/wp-content/uploads/2022/09/Revenge-Cheating-–-Definition-Signs-Types-and-How-to-Avoid-it.jpg",
            """
                    If you’re considering revenge cheating, you must stop asking yourself why. What is it that you want to achieve? Are you hoping to make your ex jealous? Do you want to make them feel bad? Or are you looking for some satisfaction from making them suffer?
                    If the answer is yes, then think again. Because one thing is for sure: if you cheat on your partner to get back at them for cheating on you, it won’t work.
                    Revenge Cheating Is Not Justifiable
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
