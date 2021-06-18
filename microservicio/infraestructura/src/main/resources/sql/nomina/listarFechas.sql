select id, idEmpleado, fechaPago, pagoEmpleado, salud, pension
from nomina
where STR_TO_DATE(fechaPago,'%d/%m/%Y') >= STR_TO_DATE(:fecha1,'%d/%m/%Y')
  and STR_TO_DATE(fechaPago,'%d/%m/%Y') <= STR_TO_DATE(:fecha2,'%d/%m/%Y')