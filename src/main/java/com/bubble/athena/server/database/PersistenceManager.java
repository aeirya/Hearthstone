
package com.bubble.athena.server.database;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class PersistenceManager {
    
    private EntityManagerFactory emFactory;
 
    PersistenceManager() {
        emFactory = Persistence.createEntityManagerFactory("athena-jpa");
    }
 
    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
 
    public void close() {
        emFactory.close();
    }
}
 