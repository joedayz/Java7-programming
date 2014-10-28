# JavaDB Database setup
# JDBC URL: jdbc:derby://localhost:1527/ProductsDB
# User: public
# Password: tiger
DROP TABLE ITEM;

CREATE TABLE ITEM (
   	ID INTEGER NOT NULL, 
   	DESCRIP VARCHAR(100), 
        PRICE REAL,
        QUANTITY INTEGER,
	PRIMARY KEY (ID)
);

INSERT INTO ITEM VALUES (110,'Blue Polo Shirt',19.95,100);
INSERT INTO ITEM VALUES (120,'Red Polo Shirt',21.95,110);
INSERT INTO ITEM VALUES (130,'Black Logo Polo Shirt',29.95,10);
INSERT INTO ITEM VALUES (140,'Khaki Shorts',12.95,25);
INSERT INTO ITEM VALUES (150,'Red Sandals',9.90,78);
