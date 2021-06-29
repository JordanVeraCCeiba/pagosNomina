
create table empleado (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 cedula int(11) not null,
 fechaNacimiento varchar(100) not null,
 salario varchar(100) not null,
 cargo varchar(100) not null,
 primary key (id)
);

create table nomina (
 id int(11) not null auto_increment,
 idEmpleado int(11) not null,
 fechaPago varchar(100) not null,
 pagoEmpleado decimal not null,
 salud decimal not null,
 pension decimal not null,
 primary key (id),
 foreign key (idEmpleado) REFERENCES empleado (id) ON DELETE CASCADE
);