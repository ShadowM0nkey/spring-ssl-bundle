# Securing Spring Boot applications with SSL Bundles

Created a working version of the code referenced in the Medium.com (aka Poor Man's Baeldung) article: 
https://medium.com/@sagar_dev/securing-spring-boot-applications-ssl-bundles-0ef6edcdc737

Code was "mostly" there. Summary of changes I needed to make:
1. Commented out spring-boot-devtools in both client/server poms. For whatever reason, having them there made every endpoint want to have static content.
2. Moved model/controller/services into the same package. In a large application it makes sense to segregate them but in a single instance demo like this it just was annoying to have show up in my IDE in different packages. 
3. Copied the server keystore/truststore to the client resource folder. The existing one had clientalias which didn't exist in any keystore. One could have created a new client keystore using the movieapp crt/key but it would have had the same stuff (if I avoided creating brand new key/crt) as the server's. Technically, the server should have its own keystore and a truststore with the client cert and the client should have a different keystore with and a truststore with the server's cert. 
4. Changed the keystore locations in application.properties to point to classpath. Why have them point to some local location when they're right there in the jar?
   a. Had to comment out the reload-on-update option because that's not valid when packaging the keystore inside a jar
