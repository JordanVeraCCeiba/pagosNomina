update empleado
set nombre = :nombre,
	apellido = :apellido,
	cedula = :cedula,
	fechaNacimiento = :fechaNacimiento,
	salario = :salario,
	cargo = :cargo
where id = :id