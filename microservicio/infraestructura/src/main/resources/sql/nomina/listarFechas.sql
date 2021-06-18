select id, idEmpleado, fechaPago, pagoEmpleado, salud, pension
from nomina
where fechaPago >= CAST(:fecha1 as date) and  fechaPago <= CAST(:fecha2 as date)