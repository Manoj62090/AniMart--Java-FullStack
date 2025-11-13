-- Users
INSERT INTO users (username, email, password, role) VALUES
('admin', 'admin@example.com', 'adminpass', 'ADMIN'),
('user1', 'user1@example.com', 'userpass', 'USER'),
('user2', 'user2@example.com', 'userpass', 'USER');

-- Anime Characters
INSERT INTO anime_characters (name, description, image_url) VALUES
('Naruto', 'Ninja from Konoha', 'naruto.jpg'),
('Sailor Moon', 'Magical girl', 'sailormoon.jpg');

-- Toys
INSERT INTO toys (name, description, price, stock, image_url, character_id) VALUES
('Naruto Action Figure', 'Poseable Naruto figure', 29.99, 10, 'naruto_toy.jpg', 1),
('Sailor Moon Doll', 'Doll of Sailor Moon', 24.99, 5, 'sailormoon_toy.jpg', 2);

-- Bookings
INSERT INTO bookings (user_id, total_amount, status) VALUES
(2, 29.99, 'CONFIRMED'),
(3, 24.99, 'PENDING');

-- Booking Items
INSERT INTO booking_items (booking_id, toy_id, quantity, price) VALUES
(1, 1, 1, 29.99),
(2, 2, 1, 24.99);

-- Ratings
INSERT INTO ratings (user_id, toy_id, rating, comment) VALUES
(2, 1, 5, 'Amazing figure!'),
(3, 2, 4, 'Good quality, nice doll');
