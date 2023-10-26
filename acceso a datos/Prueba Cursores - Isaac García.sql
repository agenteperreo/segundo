create database BECAS

use BECAS

create table AlumnoSolicitante(
	DNI		varchar(10) not null constraint PK_AlSoli primary key,
	NOMBRE	varchar(30) not null,
	NOTA	decimal(4,2),
	CUANT�A	int
);

insert into AlumnoSolicitante values ('11111111A', 'Ana Albaricoque', 9.8, 150)
insert into AlumnoSolicitante values ('22222222B', 'Beatriz Blanco', 9.5, 200)
insert into AlumnoSolicitante values ('33333333C', 'Cristina Cortina', 7.6, 100)
insert into AlumnoSolicitante values ('44444444D', 'Daniel Dado', 7.6, 100)
insert into AlumnoSolicitante values ('55555555E', 'Enriqueta Espera', 6.9, 150)
insert into AlumnoSolicitante values ('66666666F', 'Federico Frio', 6.8, 50)
insert into AlumnoSolicitante values ('77777777G', 'Guillermo Gil', 6.1, 100)

create table AlumnosConBeca(
	DNI		varchar(10) not null,
	NOMBRE	varchar(30),
	CUANT�A	int,
	primary key (DNI),
	foreign key (DNI) references AlumnoSolicitante (DNI)
);

create or alter procedure Asignaci�nBecas @cantidad int
as
begin
	
	--Declaramos las variables para el guaradar los datos del cursor
	declare @nombre varchar(30)

	declare @dni varchar(10)

	declare @cuant�a int

	--Declaramos el cursor con el dni, el nombre y la cantidad que solicita cada alumnos ordenado por nota
	declare alumnosSol cursor for
	select DNI, NOMBRE, CUANT�A from AlumnoSolicitante order by NOTA desc
	
	--Abrimos el cursor
	open alumnosSol

	--Guardamos el cursor en las variables declaradas anteriormente
	fetch alumnosSol into @dni, @nombre, @cuant�a

	--Mientras haya registros
	while(@@FETCH_STATUS = 0)
	begin
		
		--Si la cantidad es mayo o igual que la cuant�a solicitada por el alumno
		if(@cantidad >= @cuant�a)
		begin

			--Mostramos el nombre del alumno y la cantidad asiganada a este
			print 'Al alumno '+@nombre+' se le ha concedido la beca: '+cast(@cuant�a as varchar(10))
			print ''

			--Insertamos al alumno en la table de AlumnosConBeca
			insert into AlumnosConBeca values (@dni, @nombre, @cuant�a)

			--Modificamos la cantidad restandole la cuant�a del alumno
			set @cantidad -= @cuant�a

		end

		--Si no
		else
		begin

			--Mostramos que no tenemos dinero suficiente diciendo la cantidad solicitada y la que tenemos en el momento
			print 'No tenemos dinero suficiente para asignar la beca al alumno '+@nombre+'. Ha solicitado '+cast(@cuant�a as varchar(10))+' y disponemos de '+cast(@cantidad as varchar(10))
			print ''

		end

		--Guaradamos el cursor del siguiente registro
		fetch alumnosSol into @dni, @nombre, @cuant�a

	end

	--Cerramos el cursor
	close alumnosSol

	--Removemos el cursro de la cach�
	deallocate alumnosSol

	--Mostramos cunto dinero ha sobrado tras la asignaci�n de becas
	print 'Ha sobrado '+cast(@cantidad as varchar(10))+' de las asignaciones de la beca.'

end

begin transaction
	exec Asignaci�nBecas 520
rollback;

select * from AlumnoSolicitante
select * from AlumnosConBeca