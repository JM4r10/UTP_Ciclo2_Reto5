/*1. Primer informe.
Generar un informe basándose en la tabla con la información respectiva al “Líder”. El listado debe
contener: el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia. Este informe debe 
estar ordenado por la “Ciudad_Residencia” de forma alfabética.*/
select l.ID_Lider , Nombre , Primer_Apellido , Ciudad_Residencia
from Lider l
order by Ciudad_Residencia
-- WHERE NULL is NULL 


/*2. Segundo informe.
Realizar un informe basándose en la información de los proyectos cuya clasificación sea “Casa 
Campestre” y que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y “Barranquilla”. 
Este informe debe contener: el ID_Proyecto, la Constructora, el Nùmero_Habitaciones y la respectiva 
Ciudad.*/
select ID_Proyecto , Constructora , Numero_Habitaciones , Ciudad  
from Proyecto p
where Clasificacion is 'Casa Campestre' and Ciudad in ('Santa Marta', 'Cartagena' , 'Barranquilla')
-- where Clasificacion in ('Casa Campestre') and Ciudad in ('Santa Marta', 'Cartagena' , 'Barranquilla')
-- order by ID_Proyecto
;

/*3. Tercer informe.
Realizar un informe basándose en las compras realizadas por los proyectos con el proveedor 
“Homecenter” y para la ciudad “Salento”. Este informe debe incluir: ID_Compra, Constructora y 
Banco_Vinculado.*/
select c.ID_Compra , p.Constructora , p.Banco_Vinculado 
from Proyecto p  inner join Compra c on p.ID_Proyecto = c.ID_Proyecto 
where c.Proveedor = 'Homecenter' and p.Ciudad = 'Salento';  
