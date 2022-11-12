insert into ingredients (ingredientName, aisle) values
('Ground Beef', 'Meat'),
('Hamburger Buns', 'Bread'),
('Ketchup', 'Condiments'),
('Mustard', 'Condiments'),
('Onions', 'Produce'),
('Tomatoes', 'Produce'),
('Hotdogs', 'Meat'),
('Hotdog Buns', 'Bread');

--insert into recipes (recipeName, source, sourcePage, webpage) values
--('Hamburgers', 'Warren', 0, 'N/A'),
--('Hotdogs', 'Warren', 0, 'N/A');

--insert into recipes_ingredients (recipeId, ingredientId) values
--(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6),
--(2, 3), (2, 4), (2, 5), (2, 7), (2, 8)
--
--insert into quantities (recipeIngredientId, amount, measurement, optional) values
--(1, 1, 'lb', false), (2, 4, 'units', false), (3, 4, 'tbsp', false), (4, 4, 'tbsp', false),
--(5, 1, 'unit', false), (6, 1, 'unit', true),
--
--(7, 2, 'tbsp', false), (8, 2, 'tbsp', false), (9, 1, 'unit', true),
--(10, 8, 'unit', false), (11, 8, 'unit', false)