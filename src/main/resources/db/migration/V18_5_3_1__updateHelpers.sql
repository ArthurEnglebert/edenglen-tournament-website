alter table `helpers` change `is_coming_to_build` `is_coming_to_build_and_decorate` boolean not null;
alter table `helpers` drop column `is_coming_to_decorate`;
alter table `helpers` add `coming_to_build_and_decorate_start` integer null;
alter table `helpers` add `coming_to_build_and_decorate_end` integer null;
alter table `helpers` add `coming_to_un_build_start` integer null;
alter table `helpers` add `coming_to_un_build_end` integer null;