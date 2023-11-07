package pl.tutka.content.calendar.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.tutka.content.calendar.model.Content;
import pl.tutka.content.calendar.model.Status;
import pl.tutka.content.calendar.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {}

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        contentList = List.of(
            new Content(
                    1,
                    "My First Blog post",
                    "That is my first blog post",
                    Status.IDEA,
                    Type.ARTICLE,
                    LocalDateTime.now(),
                    null,
                    ""
            )
        );
    }


}
