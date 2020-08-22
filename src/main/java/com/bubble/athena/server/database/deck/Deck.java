// package com.bubble.athena.server.database.deck;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.ForeignKey;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

// import com.bubble.athena.server.database.account.Account;

// import org.hibernate.annotations.GenericGenerator;

// @Entity(name = "decks", 
//     foreignKeys = @ForeignKey(entitiy = Account.class, parentColumn = "userID", userColumn = "user", onDelete = ForeignKey.CASCADE))
// public class Deck {
//     @Id
//     @GeneratedValue(generator = "increment")
//     @GenericGenerator(name = "increment", strategy = "increment")
//     @Column(name = "deckID")
//     private int cardID;

//     private String name;

//     private int user;

// }