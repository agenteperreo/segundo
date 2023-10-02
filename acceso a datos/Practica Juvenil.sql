create database BIBLIOTECA;

USE BIBLIOTECA;

create table SOCIOS (
	DNI			varchar(10) not null constraint PK_SOCIO primary key,
	NOMBRE		varchar(20) not null,
	DIRECCION	varchar(20),
	PENALIZACIONES int default 0
);

create table LIBROS (
	