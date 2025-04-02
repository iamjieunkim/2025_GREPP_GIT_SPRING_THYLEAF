package io.jieun.greppthyleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/page")
public class TemplateController2 {

    @GetMapping("/1")
    public String syntaxPage1(String username, Model model) {
        model.addAttribute("username", username);
        return "/syntax/page1";
    }

    @GetMapping("/2")
    public String syntaxPage2(Model model) {

        List<String> shoppingList = Arrays.asList("양파", "감자", "당근", "설탕");

        //th:each
        model.addAttribute("shoppingList", shoppingList);

        return "/syntax/page2";
    }

    @GetMapping("/3")
    public String syntaxPage3(Model model) {

        model.addAttribute("post", new Post(1L, "안녕하세요!", "관리자", "안녕하세요 여러분!"));

        return "/syntax/page3";
    }

    @GetMapping("/4")
    public String syntaxPage4(Model model) {
        model.addAttribute("post", new Post());
        return "/syntax/page4";
    }

    /*
    @PostMapping("/4")
    public String processSyntaxPage4(Post post) {
        String author = "관리자";
        post.setAuthor(author);
        log.info("title={}", post.getTitle());
        log.info("contents={}", post.getContents());
        log.info("post={}", post);
        return "/syntax/page4";
    }
*/


    @PostMapping("/4")
    public String processSyntaxPage4(Post post, String author) {
        post.setAuthor(author);
        log.info("title={}", post.getTitle());
        log.info("contents={}", post.getContents());
        log.info("post={}", post);
        return "/syntax/page4";
    }

    @GetMapping("/5")
    public String syntaxPage5() {
        return "/syntax/page5";
    }

    @GetMapping("/6")
    public String syntaxPage6(Integer target, Model model) {
        model.addAttribute("target", target);
        return "/syntax/page6";
    }

    @GetMapping("/7")
    public String syntaxPage7(Model model) {
        model.addAttribute("username", "user1");

        return "/syntax/page7";
    }

    @GetMapping("/8")
    public String syntaxPage8(Model model) {
        model.addAttribute("blue", "black");
        model.addAttribute("red", "red");
        return "/syntax/page8";
    }
}
