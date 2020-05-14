package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.util.file.FileLoader;
import com.bubble.hearthstone.util.serialize.CardSerializer;
import com.bubble.hearthstone.util.serialize.ISerializer;

public class CardLoader extends ResourceLoader <CardRecord> {

    public CardRecord loadFile(String path) {
        final FileLoader fileLoader = new FileLoader(path);
        final ISerializer ser = new CardSerializer();
        final StringBuilder str = new StringBuilder();
        fileLoader.load().forEach(str::append);
        return ser.deserialize(str.toString(), CardRecord.class);
    }
}