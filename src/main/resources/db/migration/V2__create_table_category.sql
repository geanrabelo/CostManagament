create table tb_category(
	id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	user_id BIGINT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES tb_user(id)
);