package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.util.config.Config;
import com.bubble.hearthstone.util.file.FileLoader;
import com.bubble.hearthstone.util.serialize.GsonSerializer;
import com.bubble.hearthstone.util.serialize.ISerializer;

public class CardLoader extends ResourceLoader <CardRecord> {

    public CardLoader(Config resourceConfig) {
        super(resourceConfig);
    }

    @Override
    protected String getKey() {
        return "cards";
    }

    @Override
    protected CardRecord loadResource(String path) {
        final FileLoader fileLoader = new FileLoader(path);
        final ISerializer ser = new GsonSerializer();
        final StringBuilder str = new StringBuilder();
        fileLoader.load().forEach(str::append);
        return ser.deserialize(str.toString(), CardRecord.class);
    }
}