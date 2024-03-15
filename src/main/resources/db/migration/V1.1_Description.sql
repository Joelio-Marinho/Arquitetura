CREATE TABLE  IF NOT EXISTS table_Endereco(
    id INTEGER NOT NULL PRIMARY KEY,
    cep character varying(255) ,
    city character varying(255) ,
    state character varying(255) ,
    street character varying(255)
);

CREATE TABLE IF NOT EXISTS users
(
    id INTEGER NOT NULL PRIMARY KEY,
    email character varying(255) ,
    fone character varying(255),
    name character varying(255) ,
    password character varying(255) ,
    role smallint,
    endereco_id integer,
    FOREIGN KEY (endereco_id) REFERENCES table_Endereco (id)
    );

INSERT INTO table_Endereco(id,cep,city,state,street
)VALUES (1,'55555-000','TEST','TEST','TEST TEST');

INSERT INTO users( id,email,fone, name, password,  role,endereco_id)
VALUES (1,'admin@admin.com','83999999999','admin',
        '$2a$10$itNNzHsSahZpTVJBoDr3eeJGqp8290sBdBp7c3/Cc9mNlYVavoiP2',1,1);
