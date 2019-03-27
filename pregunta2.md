**2- Suponiendo que la tabla Pedidos tiene muchos registros y columnas (algunas de ellas nullable, algunas BLOB / "binary-large-object"), 
que consideraciones se deberían tener en cuenta para realizar desde un sitio web consultas a la base de datos de manera eficiente? 
Discuta performance a nivel motor de base de datos, networking, capa aplicativa desde donde se realizan las solicitudes, 
entre otros aspectos que considere relevantes.** 

Las columnas nullables se pueden normalizar a tablas separadas, o bien se puede establecer alguna convención de valores 
especiales para evitar el uso de nulls en las columnas (por ejemplo, utilizar -1 para indicar un valor nulo).

Asi mismo, en caso de los BLOBs, es conveniente normalizar estas columnas a tablas separadas para de esa manera
mantener la performance en las queries a la tabla base y consultar las tablas que contienen los BLOBs solo cuando sea necesario.

El uso de caches para acelerar el retorno de resultados ya consultados previamente se puede implementar a traves de una implementacion
provista por un framework como Spring o bien usar una estructura propia (como la clase BumexMemcached de este ejercicio.).

Las caches mantendrían una colección de los resultados de las consultas ya ejecutadas y los entregarian rapidamente
sin tener que acceder nuevamente a la base datos, ahorrando tiempo de ejecucion y ancho de banda de conexión.
Las tablas podrian utilizar indices para acelerar las busquedas de datos.

Alternativamente, es posible considerar el uso de una base de datos no relacional (como MongoDB, Cassandra, etc.). 
Estas proveerian mayor flexibilidad, ya que no resultaria necesario usar nulls (el schema de cada registro sería dinamico). 
