CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL,
  active BIT(1) NOT NULL,
  password VARCHAR(255) NULL DEFAULT NULL,
  roles VARCHAR(255) NULL DEFAULT NULL,
  user_name VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id));
  
  INSERT INTO user values (1,'1','admin','ROLE_ADMIN','admin'),
  (2,'1','user','ROLE_USER','user');