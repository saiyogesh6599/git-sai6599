-- Insert into user_app table
INSERT INTO "user_app" (username, email, password) VALUES
('jdoe', 'jdoe@example.com', 'password123'),
('asmith', 'asmith@example.com', 'password456'),
('bwayne', 'bwayne@example.com', 'batman2023'),
('ckent', 'ckent@example.com', 'superman2023'),
('pwalker', 'pwalker@example.com', 'password789'),
('ldavis', 'ldavis@example.com', 'securepass1'),
('mmiller', 'mmiller@example.com', 'strongpass2'),
('ttaylor', 'ttaylor@example.com', 'mysecurepass3'),
('jwilson', 'jwilson@example.com', 'uniquepass4'),
('hpotter', 'hpotter@example.com', 'magic1234');

-- Insert into user_roles table
INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),
(2, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(3, 'DRIVER'),
(4, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(5, 'DRIVER');

--maping one rider as the rider
INSERT INTO rider_app (rating, user_id) 
VALUES (4.9, 1);

-- Insert into driver_app table
INSERT INTO driver_app (id, user_id, rating, available, currentlocation) VALUES
(1, 1, 4.7, true, ST_GeomFromText('POINT(77.1025 28.7041)', 4326)),
(2, 2, 4.6, true, ST_GeomFromText('POINT(77.2167 28.6667)', 4326)),
(3, 3, 4.8, true, ST_GeomFromText('POINT(77.2273 28.6353)', 4326)),
(4, 4, 4.5, true, ST_GeomFromText('POINT(77.2500 28.5500)', 4326)),
(5, 5, 4.9, true, ST_GeomFromText('POINT(77.2000 28.6200)', 4326));
