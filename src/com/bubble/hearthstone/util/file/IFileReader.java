package com.bubble.hearthstone.util.file;

public interface IFileReader<T> {
    T load(String path);
}