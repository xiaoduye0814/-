create role api encrypted password 'tusc99' nosuperuser nocreatedb nocreaterole inherit login;
alter role api set search_path to maindata, pythondata;
grant all on all tables in schema[模式] db_jwfwzzzd to [用户] zzfwpt;
grant usage on schema maindata to api;
grant usage on schema pythondata to api;
grant select  on table maindata.t_area  to api;
grant select  on table maindata.t_maindata_court_execution_situation  to api;
grant select  on table maindata.t_maindata_execute  to api;
grant select  on table maindata.t_maindata_judgement to api;
grant select  on table maindata.t_maindata_judgement_ext to api;
grant select  on table maindata.t_maindata_mandatory_action to api;
grant select  on table maindata.t_maindata_product_property to api;
grant select  on table maindata.t_maindata_shaoxing_property to api;

grant select  on table pythondata.t_base_f_test to api;
grant select  on table pythondata.t_basic to api;
grant select  on table pythondata.t_basic_25_new to api;
grant select  on table pythondata.t_basic_copy to api;
grant select  on table pythondata.t_bjrsx to api;
grant select  on table pythondata.t_dsrinfo_f to api;
grant select  on table pythondata.t_extendlimit to api;
grant select  on table pythondata.t_hfajxx to api;
grant select  on table pythondata.t_kcd to api;
grant select  on table pythondata.t_qsxx to api;
grant select  on table pythondata.yuliu_t_qsxx to api;
grant select  on table pythondata.yuliu_t_qsxx01 to api;
grant select  on table pythondata.z_qsxx_002 to api;

-- 创建应用用户，并赋予相关库的DML操作权限
create role jcyclsz encrypted password 'jcyclszdbuserlogin' nosuperuser nocreatedb nocreaterole inherit login;

grant all privileges on all tables in schema db_ssclsz to jcyclsz;
grant all  on  schema  db_ssclsz to jcyclsz;

grant all privileges on all tables in schema public to jcyclsz;
grant all  on  schema  public to jcyclsz;

grant all privileges on all tables in schema Artery to jcyclsz;
grant all  on  schema  Artery to jcyclsz;

alter role jcyclsz set search_path to public, Artery, db_ssclsz;
