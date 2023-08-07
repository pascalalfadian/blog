package id.pascal.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String getIndex() {
        return "index";
    }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Post> getAllUsers() {
    // This returns a JSON or XML with the users
    return postRepository.findAll();
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
