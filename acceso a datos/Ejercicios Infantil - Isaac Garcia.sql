--EJERCICIOS

use SCOTT
--Ejercicio 1
--Haz una funci�n llamada DevolverCodDept que reciba el nombre de un departamento y devuelva su c�digo.
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
--Realiza un procedimiento llamado HallarNumEmp que recibiendo un nombre de departamento, muestre en pantalla el n�mero de empleados de dicho departamento. Puedes utilizar la funci�n creada en el ejercicio 1.
--Si el departamento no tiene empleados deber� mostrar un mensaje informando de ello. Si el departamento no existe se tratar� la excepci�n correspondiente.

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
--Realiza una funci�n llamada CalcularCosteSalarial que reciba un nombre de departamento y devuelva la suma de los salarios y comisiones de los empleados de dicho departamento. Trata las excepciones que consideres necesarias.

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
		print 'El total de los salarios y las comisiones es: '+cast(@total as varchar)+'�'
	end

--Ejercicio 4
--Realiza un procedimiento MostrarCostesSalariales que muestre los nombres de todos los departamentos y el coste salarial de cada uno de ellos. Puedes usar la funci�n del ejercicio 3.

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
--Realiza un procedimiento MostrarMasAntiguos que muestre el nombre del empleado m�s antiguo de cada departamento junto con el nombre del departamento. Trata las excepciones que consideres necesarias.

create or alter procedure MostrarMasAntiguos
as
begin

	declare @nomEm varchar(10)
	declare @nomDep varchar(14)
	declare @fecha date

	declare Departamentos cursor for select DNAME from DEPT

	open Departamentos

	fetch Departamentos into @nomDep

	while(@@FETCH_STATUS = 0)
	begin
		
		set @fecha = (select MIN(hiredate) as FechaCont from emp inner join dept on dept.DEPTNO= EMP.DEPTNO where DNAME=@nomDep)

		set @nomEm = (select ename from EMP where HIREDATE = @fecha)

		print @nomEm+' : '+@nomDep

		fetch Departamentos into @nomDep

	end

	close Departamentos

	deallocate Departamentos
end

exec MostrarMasAntiguos

--Ejercicio 7
--Realiza un procedimiento MostrarJefes que reciba el nombre de un departamento y muestre los nombres de los empleados de ese departamento que son jefes de otros empleados.Trata las excepciones que consideres necesaria

create or alter procedure MostrarJefes @nombreDept varchar(14)
as
begin

	declare @codDept int

	set @codDept = dbo.DevolverCodDept(@nombreDept)

	declare @nomEmp varchar(10)
	declare @numEmp int

	declare CursorEmpleados cursor for select ename, EMPNO from EMP

	open CursorEmpleados

	fetch CursorEmpleados into @nomEmp, @numEmp

	while(@@FETCH_STATUS = 0)
	begin

		select distinct Jefe.ename, Jefe.EMPNO from EMP as E
		inner join emp as Jefe on E.MGR=Jefe.EMPNO
		where E.DEPTNO=@codDept		

		print @nomEmp+':'+CAST(@numEmp as varchar(5))+' del departamento '+CAST(@codDept as varchar(5))

		fetch CursorEmpleados into @nomEmp, @numEmp

	end

	close CursorEmpleados

	deallocate CursorEmpleados

end

exec MostrarJefes 'RESEARCH'

--Ejercicio 8
--Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos vendedores con m�s comisiones. Trata las excepciones que consideres necesarias.

create or alter procedure MostrarMejoresVendedores
as
begin

	select top 2 COMM, ENAME from EMP where COMM is not null order by COMM desc

end

exec MostrarMejoresVendedores

--Ejercicio 10
--Realiza un procedimiento RecortarSueldos que recorte el   sueldo un 20% a los empleados cuyo nombre empiece por la  letra que recibe como par�metro.Trata las excepciones  que consideres necesarias

create or alter procedure RecortarSueldos @letra varchar(1)
as
begin

	select ename, sal from emp where ename like @letra+'%'

	update EMP
	set SAL = SAL - (SAL*20/100)
	where ENAME like @letra+'%'

	select ENAME, SAL from EMP where ENAME like @letra+'%'
end

begin tran t1

exec RecortarSueldos 'A'

rollback

--Ejercicio 11
--Realiza un procedimiento BorrarBecarios que borre a los dos empleados m�s nuevos de cada departamento. Trata las excepciones que consideres necesarias.

create or alter procedure BorrarBecarios
as
begin

	declare @numDep int

	declare borrarBec cursor for select DEPTNO from DEPT

	open borrarBec 

	fetch borrarBec into @numDep

	while(@@FETCH_STATUS = 0)
	begin
		delete from EMP where ENAME IN(select top 2 ENAME from EMP where DEPTNO = @numDep order by HIREDATE desc)

		fetch borrarBec into @numDep

	end

close borrarBec

deallocate borrarBec

end

begin tran t2

	exec BorrarBecarios

rollback