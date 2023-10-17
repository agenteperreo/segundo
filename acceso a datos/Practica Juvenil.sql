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
	
	declare cursorLibros cursor for
	select top 4 l.NOMBRE, p.REFLIBRO, l.GENERO, COUNT(*) as 'Veces prestados'
	from LIBROS l inner join PRESTAMOS p
	on l.REFLIBRO = p.REFLIBRO
	group by p.REFLIBRO, l.NOMBRE, l.GENERO
	order by 'Veces prestados' desc

	open cursorLibros

	fetch cursorLibros into @nombre, @refLibro, @genero, @vecesPrestado

	while(@@FETCH_STATUS = 0) 
	begin

		exec procesarLibro @refLibro, @nombre, @vecesPrestado, @genero

		fetch cursorLibros into @nombre, @refLibro, @genero, @vecesPrestado

	end

	close cursorLibros

	deallocate cursorLibros
end



create or alter procedure procesarLibro @refLibro varchar(10), @nombreLibro varchar(10), @vecesPrestado int, @genero varchar(10)
as 
begin

	declare @DNI varchar(10)
	declare @nombre varchar(20)
	declare @direccion varchar(20)

	declare socios cursor for 
	select s.DNI, s.NOMBRE, s.DIRECCION from SOCIOS as s, PRESTAMOS as p where s.DNI = p.DNI and p.REFLIBRO = @refLibro

	open socios

	fetch socios into @DNI, @nombre, @direccion

	while (@@FETCH_STATUS = 0)
	begin

		print 'Nombre: '+@nombre+' - DNI: '+@DNI+' - Direccion: '+@direccion
		print 'Nombre del libro: '+@nombreLibro+' - Prestamos: '+cast(@vecesPrestado as varchar(10))+' - Genero: '+@genero
		print ' '

		fetch socios into @DNI, @nombre, @direccion

	end
	
	close socios

	deallocate socios

end 

exec listadoCuatroMasPrestados

--Ejercicio 2

create database escuela

use escuela

CREATE TABLE ALUMNOS
(
  DNI VARCHAR(10) constraint PK_ALUMNOS PRIMARY KEY NOT NULL,
  APENOM VARCHAR(30),
  DIREC VARCHAR(30),
  POBLA  VARCHAR(15),
  TELEF  VARCHAR(10)  
)

CREATE TABLE ASIGNATURAS
(
  COD int constraint PK_ASIGNATURAS PRIMARY KEY NOT NULL,
  NOMBRE VARCHAR(25)
)

CREATE TABLE NOTAS
(
  DNI VARCHAR(10) FOREIGN KEY (DNI) REFERENCES ALUMNOS(DNI) NOT NULL,
  COD int FOREIGN KEY (COD) REFERENCES ASIGNATURAS (COD) NOT NULL,
  NOTA int
  CONSTRAINT PK_NOTAS PRIMARY KEY (DNI, COD)
)

INSERT INTO ASIGNATURAS VALUES (1,'Prog. Leng. Estr.');
INSERT INTO ASIGNATURAS VALUES (2,'Sist. Informáticos');
INSERT INTO ASIGNATURAS VALUES (3,'Análisis');
INSERT INTO ASIGNATURAS VALUES (4,'FOL');
INSERT INTO ASIGNATURAS VALUES (5,'RET');
INSERT INTO ASIGNATURAS VALUES (6,'Entornos Gráficos');
INSERT INTO ASIGNATURAS VALUES (7,'Aplic. Entornos 4ªGen');

INSERT INTO ALUMNOS VALUES
('12344345','Alcalde García, Elena', 'C/Las Matas, 24','Madrid','917766545');

INSERT INTO ALUMNOS VALUES
('4448242','Cerrato Vela, Luis', 'C/Mina 28 - 3A', 'Madrid','916566545');

INSERT INTO ALUMNOS VALUES
('56882942','Díaz Fernández, María', 'C/Luis Vives 25', 'Móstoles','915577545');

INSERT INTO NOTAS VALUES('12344345', 1,6);
INSERT INTO NOTAS VALUES('12344345', 2,5);
INSERT INTO NOTAS VALUES('12344345', 3,6);

INSERT INTO NOTAS VALUES('4448242', 4,6);
INSERT INTO NOTAS VALUES('4448242', 5,8);
INSERT INTO NOTAS VALUES('4448242', 6,4);
INSERT INTO NOTAS VALUES('4448242', 7,5);

INSERT INTO NOTAS VALUES('56882942', 5,7);
INSERT INTO NOTAS VALUES('56882942', 6,8);
INSERT INTO NOTAS VALUES('56882942', 7,9);

create or alter procedure ejercicio2 @modulo varchar(50)
as
begin
	
	declare @cod int

	if not exists (select @cod from ASIGNATURAS where NOMBRE=@modulo)
	begin

		print 'Esta asignatura no existe'

	end

	else
	begin

		set @cod = (select COD from ASIGNATURAS where NOMBRE=@modulo)

		set @CantAl int

		set @CantAl = (select count(DNI) from ASIGNATURAS left join NOTAS on ASIGNATURAS.COD = NOTAS.COD where ASIGNATURAS.COD=@cod)

		if @CantAl = 0
		begin

			print 'No hay alumnos en esta asignatura'

		end

		else
		begin

			declare @numSusp int
			declare @numApro int
			declare @numNotb int
			declare @numSobr int
			declare @nombre varchar(30)
			declare @nota int


		end
	end
end


select * from alumnos
select * from NOTAS
select * from ASIGNATURAS where nombre = 'Entornos Gráficos'