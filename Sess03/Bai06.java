package Sess03;

import java.util.*;

class Post {
    String title;
    List<String> tags;

    Post(String title, List<String> tags) {
        this.title = title;
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }
}

public class Bai06 {

    public static void main(String[] args) {

        List<Post> posts = Arrays.asList(
                new Post("Java Post", Arrays.asList("java", "backend")),
                new Post("Python Post", Arrays.asList("python", "data")));

        List<String> allTags = posts.stream()
                .flatMap(post -> post.getTags().stream())
                .toList();

        System.out.println(allTags);
    }
}