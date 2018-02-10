Для работы нужно 
- создать бд
- в application.properties записать название бд, логин и пароль от бд
- создать в бд релаксРумы, микроволновки, статусы состояний и пользователей, для этого можно вставить следующий код: 



INSERT INTO microwaves(id, is_free) VALUES (1, true);
INSERT INTO microwaves(id, is_free) VALUES (2, true);
INSERT INTO microwaves(id, is_free) VALUES (3, true);
INSERT INTO microwaves(id, is_free) VALUES (4, true);


INSERT INTO relax_rooms(id) VALUES (1);
INSERT INTO relax_rooms(id) VALUES (2);

INSERT INTO status(id, name_status) VALUES (1, 'ожидание');
INSERT INTO status(id, name_status) VALUES (2, 'в процессе');
INSERT INTO status(id, name_status) VALUES (3, 'готово');

INSERT INTO users(username, fio, is_free, password) VALUES ('user', 'Юзер Ю.Ю', true, 1);
INSERT INTO users(username, fio, is_free, password) VALUES ('user1', 'Пользователь П.П.', true, 1);
INSERT INTO users(username, fio, is_free, password) VALUES ('user2', 'Иванов И.И.', true, 1);
INSERT INTO users(username, fio, is_free, password) VALUES ('user3', 'Петров П.П', true, 1);
