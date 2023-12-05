create database if not exists prueba;
use prueba;

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    steam_username VARCHAR(255)
);

CREATE TABLE videogames(
    id INT PRIMARY KEY AUTO_INCREMENT,
    gamename VARCHAR(255) NOT NULL,
    platform VARCHAR(50) NOT NULL
);

CREATE TABLE parties(
    id INT PRIMARY KEY AUTO_INCREMENT,
    creator_user_id INT,
    video_game_id INT,
    party_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (creator_user_id) REFERENCES users(id),
    FOREIGN KEY (video_game_id) REFERENCES videogames(id)
);

CREATE TABLE messages(
    id INT PRIMARY KEY AUTO_INCREMENT,
    sender_user_id INT,
    party_id INT,
    content TEXT NOT NULL,
    send_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_user_id) REFERENCES users(id),
    FOREIGN KEY (party_id) REFERENCES parties(id)
);

INSERT INTO users (username, pass, email, steam_username) VALUES
('user1', 'password1', 'user1@example.com', 'steam_user1'),
('user2', 'password2', 'user2@example.com', 'steam_user2'),
('user3', 'password3', 'user3@example.com', 'steam_user3'),
('user4', 'password4', 'user4@example.com', 'steam_user4');

INSERT INTO videogames (gamename, platform) VALUES
('Metal Gear', 'PlayStation'),
('Dota', 'PC'),
('Fable', 'Xbox'),
('GTA VI', 'PC');

INSERT INTO parties (creator_user_id, video_game_id, party_name) VALUES
(1, 1, 'Party1'),
(2, 2, 'Party2'),
(3, 3, 'Party3'),
(4, 1, 'Party4');

INSERT INTO messages (sender_user_id, party_id, content) VALUES
(1, 1, 'Marc here from aprty 1'),
(2, 2, 'Xavi here from aprty 1'),
(3, 3, 'Jose here from party 2'),
(4, 1, 'Mario from party 1');


