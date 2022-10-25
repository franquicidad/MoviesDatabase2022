# MoviesDatabase2022

- El principio de responsabilidad unica nos indica que una clase debe realizar una unica cosa que no acabe teniendo varias responsabilidades logica a la vez.
en la clase UpcomingUseCase vamos a solamente devolver las peliculas que corresponde a Upcoming no vamos a mezclar con top rated ni nada. En el DAO vamos solo
a realizar operaciones de la base de datos pero solo sobre Upcoming nada mas.Su proposito es tener un codigo mas organizado y que alguien que ve el 
codigo por primera vez le sea facil entender que va a suceder en una clase solo con el nombre.

- El codigo limpio es un conjunto de caracteristicas que permiten a una programador entender mas facilmente que esta haciendo el programa. El nombre de una
funcion debe expresar una accion y lo que hace si es posible con 0 parametros max 3 y 4 lineas de codigo.Esto anterior para hacer mas facil el testing de una funcion.
No usar muchos when en tu codigo. Generalmente muchos comentarios en un programa indica que es dificil de leer por si mismo. No repetir codigo.

- Se me paso ocultar la api key. Se hace con el build config Field.
Properties properties = new Properties()
properties.load(project.rootProject.file("local.properties").newDataInputStream())

buildConfigField "String","API_KEY","\"${properties.getProperty("API_KEY")}\""

- Me falto el tema de los trailers pero solo basta consultar la documentacion de la api. En este momente no esta disponible el servicio.
<img width="851" alt="Screen Shot 2022-10-23 at 10 04 29 PM" src="https://user-images.githubusercontent.com/28768991/197440872-b28dc76c-4235-427a-a620-8003c11ba8a1.png">


PANTALLA PRINCIPAL.
<img width="338" alt="Screen Shot 2022-10-23 at 10 08 44 PM" src="https://user-images.githubusercontent.com/28768991/197441164-d57a3267-4f11-4c5f-a269-4e3b3af72a78.png">

PANTALLA DETALLE.
<img width="345" alt="Screen Shot 2022-10-23 at 10 08 55 PM" src="https://user-images.githubusercontent.com/28768991/197441359-bf4ea3b5-bdd9-4aa7-a6a7-70e87ce5e0c7.png">



