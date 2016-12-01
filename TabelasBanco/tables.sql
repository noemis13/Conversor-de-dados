create table wkt(
	known_text TEXT not null,
	id_wkt serial,
	primary key (id_wkt)
);

create table statefp(
	id_state integer,
	id_statefp serial,
	primary key (id_statefp)
);

create table countyfp(
	code_fip integer,
	id_countyfp serial,
	primary key (id_countyfp)
);

create table lfromadd(
	number_house_adress_left_border varchar(50),
	id_lfromadd serial,
	primary key (id_lfromadd)
);

create table ltoadd(
	number_house_left_border varchar(50),
	id_ltoadd serial,
	primary key (id_ltoadd)
);

create table rfromadd(
	number_house_adress_right_border varchar(50),
	id_rfromadd serial,
	primary key (id_rfromadd)
);

create table rtoadd(
	number_house_right_border varchar(50),
	id_rtoadd serial,
	primary key (id_rtoadd)
);

create table zipl(
	zip_code_left integer,
	id_zipl serial,
	primary key (id_zipl)
);

create table zipr(
	zip_code_right integer,
	id_zipr serial,
	primary key (id_zipr)
);


create table tfidl(
	left_face_id integer,
	id_lfromadd integer,
	id_ltoadd integer,
	id_zipl integer,
	id_tfidl serial,
	primary key (id_tfidl),
	constraint fk_lfromadd foreign key (id_lfromadd) references lfromadd(id_lfromadd),
	constraint fk_ltoadd foreign key (id_ltoadd) references ltoadd(id_ltoadd),
	constraint fk_zipl foreign key (id_zipl) references zipl(id_zipl)
);

create table tfidr(
	right_face_id integer,
	id_rfromadd integer,
	id_rtoadd integer,
	id_zipr integer,
	id_tfidr serial,
	primary key (id_tfidr),
	constraint fk_rfromadd foreign key (id_rfromadd) references rfromadd(id_rfromadd),
	constraint fk_rtoadd foreign key (id_rtoadd) references rtoadd(id_rtoadd),
	constraint fk_zipr foreign key (id_zipr) references zipr(id_zipr)
);

create table tnidf(
	first_node integer,
	id_tnidf serial,
	primary key (id_tnidf)
);

create table tnidt(
	border_node integer,
	id_tnidt serial,
	primary key (id_tnidt)
);

create table tlid(
	border_id integer,
	id_tnidf integer,
	id_tnidt integer,
	id_tfidl integer,
	id_tfidr integer,
	id_tlid serial,
	primary key (id_tlid),
	constraint fk_tnidf foreign key (id_tnidf) references tnidf(id_tnidf),
	constraint fk_tnidt foreign key (id_tnidt) references tnidt(id_tnidt),
	constraint fk_tfidl foreign key (id_tfidl) references tfidl(id_tfidl),
	constraint fk_tfidr foreign key (id_tfidr) references tfidr(id_tfidr)
);


create table mtfcc(
	code_face varchar(100),
	id_mtfcc serial,
	primary key (id_mtfcc)
	
);


create table smid(
	especial_metadados integer,
	id_smid serial,
	primary key (id_smid)
);


create table hydroflg(
	hydraulic_resources varchar(50),
	id_hydroflg serial,
	primary key (id_hydroflg)

);

create table railflg(
	rail_resources varchar(50),
	id_railflg serial,
	primary key (id_railflg)

);

create table roadflg(
	road_resources varchar(50),
	id_roadflg serial,
	primary key (id_roadflg)
);

create table deckedroad(
	decked_road_id varchar(50),
	id_deckedroad serial,
	primary key (id_deckedroad)
);

create table ttyp(
	pack_type varchar(50),
	id_ttyp serial,
	primary key (id_ttyp)
);

create table artpath(
	artificial_pack_id varchar(50),
	id_ttyp integer,
	id_artpath serial,
	primary key (id_artpath),
	constraint fk_ttyp foreign key (id_ttyp) references ttyp(id_ttyp)
);

create table featcat(
	general_characteristics varchar(50),
	id_hydroflg integer,
	id_railflg integer,
	id_roadflg integer,
	id_deckedroad integer,
	id_artpath integer,
	id_featcat serial,
	primary key (id_featcat),
	constraint fk_hydroflg foreign key (id_hydroflg) references hydroflg(id_hydroflg),
	constraint fk_railflg foreign key (id_railflg) references railflg(id_railflg),
	constraint fk_roadflg foreign key (id_roadflg) references roadflg(id_roadflg),
	constraint fk_deckedroad foreign key (id_deckedroad) references deckedroad(id_deckedroad),	
	constraint fk_artpath foreign key (id_artpath) references artpath(id_artpath)
);

create table divroad(
	div_road_flag varchar(50),
	id_divroad serial,
	primary key (id_divroad)
	
);

create table passflg(
	especial_pass_flag varchar(50),
	id_passflg serial,
	primary key (id_passflg)
);

create table persist(
	geograph_persist_flag varchar(50),
	id_persist serial,
	primary key (id_persist)
);

create table offsetl(
	left_flag varchar(50),
	id_offsetl serial,
	primary key (id_offsetl)
);

create table olfflg(
	linear_id varchar(50),
	id_divroad integer,
	id_passflg integer,
	id_persist integer,
	id_olfflg serial,
	primary key (id_olfflg),
	constraint fk_divroad foreign key (id_divroad) references divroad(id_divroad),
	constraint fk_passflg foreign key (id_passflg) references passflg(id_passflg),
	constraint fk_persist foreign key (id_persist) references persist(id_persist)
);


create table exttyp(
	extension_type varchar(50),
	id_exttyp serial,
	primary key (id_exttyp)
);


create table offsetr(
	right_side varchar(50),
	id_offsetr serial,
	primary key (id_offsetr)
);

create table gcseflg(
	geograph_flag varchar(50),
	id_gcseflg serial,
	primary key (id_gcseflg)
);


create table fullname(
	name_edges varchar(100),
	id_fullname serial,
	id_wkt integer,
	id_statefp integer,
	id_countyfp integer,
	id_tlid integer,
	id_tfidl integer,
	id_tfidr integer,
	id_mtfcc integer,
	id_smid integer,
	id_lfromadd integer,
	id_ltoadd integer,
	id_rfromadd integer,
	id_rtoadd integer,
	id_zipl integer,
	id_zipr integer,
	id_hydroflg integer,
	id_railflg integer,
	id_roadflg integer,
	id_passflg integer,
	id_divroad integer,
	id_exttyp integer,
	id_deckedroad integer,
	id_artpath integer,
	id_persist integer,
	id_gcseflg integer,
	id_offsetl integer,
	id_offsetr integer,
	id_tnidf integer,
	id_tnidt integer,
	primary key (id_fullname),
	constraint fk_wkt foreign key (id_wkt) references wkt(id_wkt),
	constraint fk_statefp foreign key (id_statefp) references statefp(id_statefp),
	constraint fk_countyfp foreign key (id_countyfp) references countyfp(id_countyfp),
	constraint fk_tlid foreign key (id_tlid) references tlid(id_tlid),
	constraint fk_tfidl foreign key (id_tfidl) references tfidl(id_tfidl),
	constraint fk_tfidr foreign key (id_tfidr) references tfidr(id_tfidr),
	constraint fk_mtfcc foreign key (id_mtfcc) references mtfcc(id_mtfcc),
	constraint fk_smid foreign key (id_smid) references smid(id_smid),
	constraint fk_lfromadd foreign key (id_lfromadd) references lfromadd(id_lfromadd),
	constraint fk_ltoadd foreign key (id_ltoadd) references ltoadd(id_ltoadd),
	constraint fk_rfromadd foreign key (id_rfromadd) references rfromadd(id_rfromadd),
	constraint fk_rtoadd foreign key (id_rtoadd) references rtoadd(id_rtoadd),
	constraint fk_zipl foreign key (id_zipl) references zipl(id_zipl),
	constraint fk_zipr foreign key (id_zipr) references zipr(id_zipr),
	constraint fk_hydroflg foreign key (id_hydroflg) references hydroflg(id_hydroflg),
	constraint fk_railflg foreign key (id_railflg) references railflg(id_railflg),
	constraint fk_roadflg foreign key (id_roadflg) references roadflg(id_roadflg),
	constraint fk_passflg foreign key (id_passflg) references passflg(id_passflg),
	constraint fk_divroad foreign key (id_divroad) references divroad(id_divroad),
	constraint fk_exttyp foreign key (id_exttyp) references exttyp(id_exttyp),
	constraint fk_deckedroad foreign key (id_deckedroad) references deckedroad(id_deckedroad),
	constraint fk_artpath foreign key (id_artpath) references artpath(id_artpath),
	constraint fk_persist foreign key (id_persist) references persist(id_persist),
	constraint fk_gcseflg foreign key (id_gcseflg) references gcseflg(id_gcseflg),
	constraint fk_offsetl foreign key (id_offsetl) references offsetl(id_offsetl),
	constraint fk_offsetr foreign key (id_offsetr) references offsetr(id_offsetr),
	constraint fk_tnidf foreign key (id_tnidf) references tnidf(id_tnidf),
	constraint fk_tnidt foreign key (id_tnidt) references tnidt(id_tnidt)
	
);