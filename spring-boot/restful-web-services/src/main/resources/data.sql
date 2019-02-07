insert into user (id, name, birth_date, phone_number, social_security_number) values (hibernate_sequence.nextval, 'Joe', sysDate(), '1234567890', '123456789');
insert into user (id, name, birth_date, phone_number, social_security_number) values (hibernate_sequence.nextval, 'Adam', sysDate(), '2345678901', '234567890');
insert into user (id, name, birth_date, phone_number, social_security_number) values (hibernate_sequence.nextval, 'Chloe', sysDate(), '3456789012', '345678901');
insert into post (id, description, user_id) values (hibernate_sequence.nextval, 'First Post', 1);
insert into post (id, description, user_id) values (hibernate_sequence.nextval, 'First Post', 2);