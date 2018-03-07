--users
insert into users (username, password, role) values ('davioooh', 'pwd1234', 0);
insert into users (username, password, role) values ('mario', 'pwd1234', 1);

--books
insert into books (title, author, publication_year, type) values
    ('Il vecchio e il mare', 'Ernest Hemingway', 1952, 0),
    ('Il signore degli anelli', 'J. R. R. Tolkien', 1955, 0),
    ('Il ritratto di Dorian Gray', 'Oscar Wilde', 1890, 0)
;