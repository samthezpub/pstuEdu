package com.example.ptsuedu.Service.Implementation;

import com.example.ptsuedu.Entity.Post;
import com.example.ptsuedu.Repository.PostRepository;

import com.example.ptsuedu.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImplementation implements PostService {

    private PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Post getPostById(Long id) {
        // TODO
        return null;
    }
}