create table tb_cost(
	id SERIAL NOT NULL PRIMARY KEY,
	description VARCHAR(150) NOT NULL,
	value NUMERIC NOT NULL,
	date TIMESTAMP NOT NULL,
	category_id BIGINT NOT NULL,
	user_id BIGINT NOT NULL,
	FOREIGN KEY (category_id) REFERENCES tb_category(id),
	FOREIGN KEY (user_id) REFERENCES tb_user(id)
);