package challenge.alura.foro.challenge.alura.foro.controller;


import challenge.alura.foro.challenge.alura.foro.domain.course.model.Course;
import challenge.alura.foro.challenge.alura.foro.domain.course.repository.CourseRepository;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicListData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicRegistrationData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicResponseData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicUpdateData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import challenge.alura.foro.challenge.alura.foro.domain.topic.repository.TopicRepository;
import challenge.alura.foro.challenge.alura.foro.domain.topic.service.TopicService;
import challenge.alura.foro.challenge.alura.foro.domain.user.model.User;
import challenge.alura.foro.challenge.alura.foro.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid TopicRegistrationData topicRegistrationData, UriComponentsBuilder uriBuilder){
        TopicResponseData topic = topicService.save(topicRegistrationData);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.id()).toUri();
        return ResponseEntity.created(uri).body(topic);
    }

    @GetMapping
    public ResponseEntity<Page<TopicListData>> list(@PageableDefault(size = 10) Pageable pageable){
        var page = topicService.list(pageable);
        return ResponseEntity.ok(page);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseData> unit(@PathVariable Long id){
        var topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicResponseData(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicResponseData> update(@PathVariable Long id, @RequestBody TopicUpdateData topicUpdateData){
        var topic = topicService.update(id, topicUpdateData);
        return ResponseEntity.ok(new TopicResponseData(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicResponseData> delete(@PathVariable Long id){
        topicService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
