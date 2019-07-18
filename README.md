# Reisende
Gra którą piszę na moją pracę licencjacką
CREATE TABLE d_user_phone (
    phone_number_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY(phone_number_id) REFERENCES d_phone(phone_id),
    FOREIGN KEY(user_id) REFERENCES d_user(id)
);
