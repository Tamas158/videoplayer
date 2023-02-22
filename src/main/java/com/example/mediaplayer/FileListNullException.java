package com.example.mediaplayer;

public class FileListNullException extends Exception{

    FileListNullException(String error) {
        System.out.println(error);
    }

    FileListNullException(){
        System.out.println("This file list is null");

    }
}
