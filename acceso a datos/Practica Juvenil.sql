create database BIBLIOTECA;

USE BIBLIOTECA;

create table SOCIOS (
	DNI			varchar(10) not null constraint PK_SOCIO primary key,
	NOMBRE		varchar(20) not null,
	DIRECCION	varchar(20),
	PENALIZACIONES int default 0
);

create table LIBROS (
	REFLIBRO	varchar(10) not null constraint PK_LIBROS primary key,
	NOMBRE		varchar(30) not null,
	AUTOR		varchar(20) not null,
	GENERO		varchar(10),
	ANOPUBLICACION	int,
	EDITORIAL	varchar(10)
);

create table PRESTAMOS(
	DNI			varchar(10) not null,
	REFLIBRO	varchar(10) not null,
	FECHAPRESTAMO	date not null,
	DURACION	int default 24,
	primary key (DNI, REFLIBRO,FECHAPRESTAMO),
	foreign key (dni) references SOCIOS (DNI),
	foreign key (REFLIBRO) references LIBROS (REFLIBRO)
);

INSERT INTO socios VALUES ('111-A', 'David',   'Sevilla Este', 2);
INSERT INTO socios VALUES ('222-B', 'Mariano', 'Los Remedios', 3);

INSERT INTO socios (DNI, Nombre, Direccion)
VALUES ('333-C', 'Raul',    'Triana'      );

INSERT INTO socios (DNI, Nombre, Direccion)
VALUES ('444-D', 'Rocio',   'La Oliva'    );

INSERT INTO socios VALUES ('555-E', 'Marilo',  'Triana',       2);
INSERT INTO socios VALUES ('666-F', 'Benjamin','Montequinto',  5);

INSERT INTO socios (DNI, Nombre, Direccion)
VALUES ('777-G', 'Carlos',  'Los Remedios');

INSERT INTO socios VALUES ('888-H', 'Manolo',  'Montequinto',  2);


INSERT INTO libros
VALUES('E-1', 'El valor de educar', 'Savater',    'Ensayo', 1994, 'Alfaguara');
INSERT INTO libros
VALUES('N-1', 'El Quijote',         'Cervantes',  'Novela', 1602, 'Anagrama');
INSERT INTO libros
VALUES('E-2', 'La Republica',       'Plat?n',     'Ensayo', -230, 'Anagrama');
INSERT INTO libros
VALUES('N-2', 'Tombuctu',           'Auster',     'Novela', 1998, 'Planeta');
INSERT INTO libros
VALUES('N-3', 'Todos los nombres',  'Saramago',   'Novela', 1995, 'Planeta');
INSERT INTO libros
VALUES('E-3', 'Etica para Amador',  'Savater',    'Ensayo', 1991, 'Alfaguara');
INSERT INTO libros
VALUES('P-1', 'Rimas y Leyendas',   'Becquer',    'Poesia', 1837, 'Anagrama');
INSERT INTO libros
VALUES('P-2', 'Las flores del mal', 'Baudelaire', 'Poesia', 1853, 'Anagrama');
INSERT INTO libros
VALUES('P-3', 'El fulgor',          'Valente',    'Poesia', 1998, 'Alfaguara');
INSERT INTO libros
VALUES('N-4', 'Lolita',             'Nabokov',    'Novela', 1965, 'Planeta');
INSERT INTO libros
VALUES('C-1', 'En salvaje compa?ia','Rivas',      'Cuento', 2001, 'Alfaguara');


INSERT INTO prestamos VALUES('111-A','E-1', '17/12/00',24);
INSERT INTO prestamos VALUES('333-C','C-1', '15/12/01',48);
INSERT INTO prestamos VALUES('111-A','N-1', '17/12/01',24);
INSERT INTO prestamos VALUES('444-D','E-1', '17/12/01',48);
--INSERT INTO prestamos VALUES('111-A','C-2', '17/12/01',72);

INSERT INTO prestamos (DNI, RefLibro, FechaPrestamo) 
VALUES('777-G','N-1', '07/12/01');

INSERT INTO prestamos VALUES('111-A','N-1', '16/12/01',48);


/*
Cursor de los 4 libros mas prestados
Recorro los libros y paa cada libro
	cursor de los socios de ese libro
*/

select * from PRESTAMOS

create or alter procedure listadoCuatroMasPrestados
as
begin

	declare @nombre varchar(20)
	declare @refLibro varchar(10)
	declare @genero varchar(10)
	declare @vecesPrestado int
	
	declare cursor cursorLibros for
	select top 4 l.NOMBRE, p.REFLIBRO, l.GENERO, COUNT(*) as 'Veces prestados'
	from LIBROS l inner join PRESTAMOS p
	on l.REFLIBRO = p.REFLIBRO
	group by p.REFLIBRO, l.NOMBRE, l.GENERO
	order by 'Veces prestados' desc

	open cursorLibros

	fetch cursorLibros into @nombre, @refLibro, @genero, @vecesPrestados

	while(@@FETCH_STATUS = 0) 
	begin
		
		procesaLibro @variables, @refLibro

	end

	close cursorLibros

	deallocate cursorLibros
end



create or alterprocedure procesarLibro @param
	print @nombreLibro + numP + @fecha

	declare cursor select sociosDeLsPrestamos
	open cursor
	fetch into 
	-- mientras haya socios de ese libro
	while
		print socio