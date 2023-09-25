--EJERCICIOS

use SCOTT
--Ejercicio 1
--Haz una función llamada DevolverCodDept que reciba el nombre de un departamento y devuelva su código.
create function DevolverCodDept (
	@DEPTNAME varchar(14)
)
returns int
as
begin
	
	declare @codDept int

	set @codDept = (select DEPTNO from DEPT where DNAME = @DEPTNAME)

	return @codDept

end


declare @codD int
set @codD = dbo.DevolverCodDept('OPERATIONS')
print @codD


--Ejercicio 2
--Realiza un procedimiento llamado HallarNumEmp que recibiendo un nombre de departamento, muestre en pantalla el número de empleados de dicho departamento. Puedes utilizar la función creada en el ejercicio 1.
--Si el departamento no tiene empleados deberá mostrar un mensaje informando de ello. Si el departamento no existe se tratará la excepción correspondiente.

drop procedure HallarNumEmp

create procedure HallarNumEmp 
	@name varchar(14)
as
begin

	declare @noemp int

	set @noemp = (select count(EMPNO) from EMP where DEPTNO = (select DEPTNO from DEPT where DNAME = @name))

	if not exists(select DEPTNO from DEPT where DNAME = @name)
		begin
			print 'El departamento no existe'
		end
	else
		begin
			if @noemp = 0
				begin
					print 'El departamento no tiene empleados'
				end
			else
				begin
					print 'El departamento tiene '+cast(@noemp as varchar)+' empleados.'
				end
		end

end

exec HallarNumEmp 'RESEARCH'


--Ejercicio 3
--Realiza una función llamada CalcularCosteSalarial que reciba un nombre de departamento y devuelva la suma de los salarios y comisiones de los empleados de dicho departamento. Trata las excepciones que consideres necesarias.

create or alter function CalcularCosteSalarial(
	@deptName varchar(14)
)
returns int
as
begin

	declare @sumTotal int

	if not exists(select DEPTNO from DEPT where DNAME = @deptName)
		begin
			set @sumTotal = -1
		end
	else if @deptName = 'OPERATIONS'
		begin
			set @sumTotal = 0
		end
	else
		begin
			declare @sumSal int, @sumComm int 

			set @sumSal = (select sum(isnull(SAL, 0)) from EMP where DEPTNO = (select DEPTNO from DEPT where DNAME = @deptName))

			set @sumComm = (select sum(isnull(COMM, 0)) from EMP where DEPTNO = (select DEPTNO from DEPT where DNAME = @deptName))

			set @sumTotal = @sumComm + @sumSal

		end

	return @sumTotal

end

declare @total int
set @total = dbo.CalcularCosteSalarial('RESEARCH')

if @total = -1
	begin
		print 'El departamento no existe'
	end
else if @total = 0
	begin
		print 'El departamento no tiene empleados por lo que no consume salario'
	end
else
	begin
		print 'El total de los salarios y las comisiones es: '+cast(@total as varchar)+'€'
	end

--Ejercicio 4
--Realiza un procedimiento MostrarCostesSalariales que muestre los nombres de todos los departamentos y el coste salarial de cada uno de ellos. Puedes usar la función del ejercicio 3.

create or alter procedure MostrarCostesSalariales
as
begin

	declare @nom varchar(50)

	declare NombreCosteSalarial cursor
	for
		select DNAME from DEPT

	open NombreCosteSalarial

	fetch NombreCosteSalarial into @nom

	declare @coste int

	set @coste = dbo.CalcularCosteSalarial(@nom)

	while (@@FETCH_STATUS = 0) 
	begin
		print @nom+' : '+cast(@coste as varchar(50))

		fetch NombreCosteSalarial into @nom

		set @coste = dbo.CalcularCosteSalarial(@nom)
	end

	close NombreCosteSalarial

	deallocate NombreCosteSalarial

end

exec MostrarCostesSalariales


--Ejercicio 5
--Realiza un procedimiento MostrarAbreviaturas que muestre las tres primeras letras del nombre de cada empleado.

create or alter procedure MostrarAbreviaturas
as 
begin

	select substring(ENAME, 1, 3) from EMP

end

exec MostrarAbreviaturas

--Ejercicio 6
--Realiza un procedimiento MostrarMasAntiguos que muestre el nombre del empleado más antiguo de cada departamento junto con el nombre del departamento. Trata las excepciones que consideres necesarias.

create or alter procedure MostrarMasAntiguos
as
begin
end


--Ejercicio 8
--Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos vendedores con más comisiones. Trata las excepciones que consideres necesarias.

create or alter procedure MostrarMejoresVendedores
as
begin

	select top 2 COMM, ENAME from EMP where COMM is not null order by COMM desc

end

exec MostrarMejoresVendedores