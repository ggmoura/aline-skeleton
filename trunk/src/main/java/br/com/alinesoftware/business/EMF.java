package br.com.alinesoftware.business;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.appengine.api.utils.SystemProperty;

public final class EMF {
    private static  EntityManagerFactory emfInstance;
    static {
    	
    	Map<String, String> properties = new HashMap<>();
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.GoogleDriver");
			properties.put("javax.persistence.jdbc.url", System.getProperty("cloudsql.url"));
		} else {
			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
			properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/aline");
		}
		
		emfInstance = Persistence.createEntityManagerFactory("transaction_aline", properties);
		
    	
    }

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
    
 
}