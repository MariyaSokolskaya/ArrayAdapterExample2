package com.example.admin215.arrayadapterexample;

/**
 * Created by Admin215 on 15.02.2018.
 */

public class Book implements Comparable <Book>{
    String author;
    String name;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return author + " " + name;
    }

    @Override
    public int compareTo(Book book) {
        return author.compareTo(book.author);
    }
}

