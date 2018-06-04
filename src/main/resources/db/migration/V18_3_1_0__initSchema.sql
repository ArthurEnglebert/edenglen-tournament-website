create table `inscriptions` (
  id bigint not null AUTO_INCREMENT,
  name varchar(255) not null,
  first_name varchar(255) not null,
  email varchar(255) not null,
  phone varchar(255) not null,
  donation integer null,
  amount integer not null,
  is_paid boolean not null,
  PRIMARY KEY (`id`)
);

create table `players` (
  id bigint not null AUTO_INCREMENT,
  `inscription_id` bigint not null,
  name varchar(255) not null,
  first_name varchar(255) not null,
  email varchar(255) not null,
  age integer not null,
  sex varchar(50) not null,
  skill_level varchar(255) not null,
  phone varchar(255) not null,
  championship_level varchar(255) not null,
  is_dining tinyint(1) not null default false,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_players_inscription` FOREIGN KEY (`inscription_id`) REFERENCES `inscriptions`(`id`)
);

create table `eaters` (
  id bigint not null AUTO_INCREMENT,
  `inscription_id` bigint not null,
  name varchar(255) not null,
  first_name varchar(255) not null,
  age integer not null,
  email varchar(255) not null,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_eaters_inscription` FOREIGN KEY (`inscription_id`) REFERENCES `inscriptions`(`id`)
);

create table `helpers` (
  `id` bigint not null AUTO_INCREMENT,
  name varchar(255) not null,
  first_name varchar(255) not null,
  phone varchar(255) not null,
  is_bringing_food boolean not null,
  is_coming_to_build boolean not null,
  is_coming_to_un_build boolean not null,
  is_coming_to_decorate boolean not null,
  number_coming integer not null,
  PRIMARY KEY (`id`)
);