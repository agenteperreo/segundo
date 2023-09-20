--EJERCICIOS

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

