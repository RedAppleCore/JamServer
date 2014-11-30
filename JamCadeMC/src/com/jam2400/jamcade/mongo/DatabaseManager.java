package com.jam2400.jamcade.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
 
/**
* Programmed by: DevRo_ (Erik Rosemberg)
* Creation Date: 03, 01, 2014
* Programmed for the Currency+ project.
*/
public class DatabaseManager {
private static MongoClient mongoClient;
private static DB db;
private static DBCollection users;

 
public static void connect(String host, int port) {
	try {
		mongoClient = new MongoClient(host, port);
	} catch (Exception e) {
		System.out.println("Couldn't connect to database!.");
	}
	db = getMongoClient().getDB("test");
	users = getMongoDB().getCollection("users");
}
 
public static void createNewData() {
	if (mongoClient != null) {
	mongoClient.close();
	}
	mongoClient = null;
	db = null;
	users = null;
	}
 
 
public static MongoClient getMongoClient() {
	return (mongoClient);
}
 
public static DB getMongoDB() {
	return (db);
}
 
public static DBCollection getPlayers() {
	return (users);
}
 
}
