alter table `helpers` change `is_coming_to_build_and_decorate` `is_coming_to_build` boolean not null;
alter table `helpers` change `coming_to_build_and_decorate_start` `coming_to_build_start` integer null;
alter table `helpers` change `coming_to_build_and_decorate_end` `coming_to_build_end` integer null;

alter table `helpers` add `is_coming_to_decorate` boolean null;
alter table `helpers` add `coming_to_decorate_start` integer null;
alter table `helpers` add `coming_to_decorate_end` integer null;

update `helpers` set `is_coming_to_decorate` = `is_coming_to_build`;
update `helpers` set `coming_to_decorate_start` = `coming_to_build_start`;
update `helpers` set `coming_to_decorate_end` = `coming_to_build_end`;

alter table `helpers` change `is_coming_to_decorate` `is_coming_to_decorate` boolean not null;