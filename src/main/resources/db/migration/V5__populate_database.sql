insert into categories (name) values
('Fruits'),
('Vegetables'),
('Dairy'),
('Bakery'),
('Beverages');

insert into products (name, price, description, category_id) values
('Bananas', 1.29, 'Fresh organic bananas from Ecuador. Sold per pound.', 1),
('Granny Smith Apples', 2.49, 'Crisp and tart apples perfect for pies or snacking.', 1),
('Carrots', 0.99, 'Organic carrots, rich in beta-carotene. Sold per lb.', 2),
('Broccoli', 1.75, 'Fresh broccoli florets. Steam or stir-fry ready.', 2),
('Whole Milk', 3.49, '1 gallon of whole dairy milk. Vitamin D enriched.', 3),
('Cheddar Cheese', 4.99, 'Sharp aged cheddar cheese, 8 oz block.', 3),
('Sourdough Bread', 3.99, 'Freshly baked sourdough loaf from local bakery.', 4),
('Croissants', 2.49, 'Flaky, buttery croissants. Perfect with coffee.', 4),
('Orange Juice', 4.29, '100% pure squeezed orange juice, 1L bottle.', 5),
('Green Tea', 2.99, 'Organic green tea bags (20 count). Light and refreshing.', 5);
