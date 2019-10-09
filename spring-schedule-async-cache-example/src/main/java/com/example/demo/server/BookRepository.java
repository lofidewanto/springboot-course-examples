package com.example.demo.server;

public interface BookRepository {

	Book getByIsbn(String isbn);

}