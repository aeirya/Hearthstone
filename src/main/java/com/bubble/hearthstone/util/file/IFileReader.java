package com.bubble.hearthstone.util.file;

import java.net.URL;

public interface IFileReader<T> {
    
    T load(String path);
}