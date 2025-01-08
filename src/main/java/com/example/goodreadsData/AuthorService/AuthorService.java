package com.example.goodreadsData.AuthorService;

import com.example.goodreadsData.Author.Author;
import com.example.goodreadsData.AuthorRepository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void saveAuthor(){
        Author author = new Author();
        author.setId("id");
        author.setName("Name");
        author.setPersonalName("personal name");
        authorRepository.save(author);
    }
}
