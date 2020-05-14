// package com.bubble.hearthstone.util.serialize;

// import org.junit.Test;
// import static org.junit.Assert.*;
// import com.bubble.hearthstone.card.abilities.AbilityDamage;

// public class SerializerTest {
    
//     @Test public void deserializeTest() {
//         GsonSerializer g = new GsonSerializer();
//         AbilityDamage r = new AbilityDamage();
//         assertNotNull("Serializing suckz..",
//             g.serialize(
//                 g.deserialize(
//                     g.serialize(r)
//                 , AbilityDamage.class)
//             ).toString()
//             );
//     }
// }