package com.win.techtalentblog.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping
    public String index(BlogPost blogPost) {
        return "index";
    }

    private BlogPost blogPost;

    @PostMapping
    private String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "result";
    }
}