CREATE TABLE freezer (
	id INTEGER PRIMARY KEY,
	food_id INTEGER NOT NULL,
	num INTEGER NOT NULL,
	lim INTEGER NOT NULL,
	create_time DATE NOT NULL
);