package id.pascal.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @GetMapping("/blog")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/blog/create")
    public String getCreate() {
        return "create";
    }

    @GetMapping("/blog/read")
    public String read(@RequestParam(name="slug", required=true) String slug, Model model) {
        model.addAttribute("slug", slug);
        return "read";
    }
}
