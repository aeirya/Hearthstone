package com.bubble.hearthstone.util.resource;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.util.serialize.CardSerializer;
import com.bubble.hearthstone.util.serialize.GsonSerializer;

public class JsonLoader {


    public <T> T load(String path, Class<T> clazz)
    {
        final FileLoader fileLoader = new FileLoader();
        final String file = fileLoader.loadFile(path);
        //i will be needing to change the implementation given to the serializer later
        final GsonSerializer ser = new CardSerializer(); 
        ser.registerTypeAdapter(Purchasable.class, Deck.sampleCard);

        //to prevent the loading decks bug
        return ser.deserialize(file, clazz);
    }
}