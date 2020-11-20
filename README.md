# ClienteServidorHilos

_Este proyecto consiste en la implementacion de Sockets e Hilos para hacer una pequeña sala de chat entre Clientes en un mismo Servidor._

## Introducción 

_Desarrollo de un chat cliente-servidor. En esta práctica mostraremos cómo hacer un chat
mediante el uso de Sockets en Java. Los Sockets sirven para comunicar procesos de diferentes
máquinas de una red.
Haremos un servidor y un cliente utilizando Sockets: 
-- Del lado del Servidor se tiene un bucle infinito que espera conexiones de clientes. Cuando un 
cliente se conecta el servidor acepta la conexión y genera al menos dos threads: uno para enviar 
datos y el otro para recibirlos. 
-- Del lado del Cliente se tiene que esperar un Servidor para poder conectarse, cuando se conecta
al servidor se generan dos threads, al igual que en el Servidor uno para enviar y otro para
recibir los datos. 
La clase principal del Servidor es idéntica a la clase principal del cliente; la
única diferencia esta en el main, el servidor espera conexiones del cliente y el cliente busca
servidor para conectarse._


### Pre-requisitos 

_Para la ejecución de este programa es necesario dos Librerias, la libreria nativa de Java "Absolute Layout.jar" incluida en la carpeta Lib

Para compilar el programa con Librerias desde CMD utilizar este comando desues de estar en la carpeta de las clases y haber corrido la maquina virtual de Java en la terminal
```
javac -cp Lib/AbsoluteLayout.jar Servidor/*.java Cliente/*.java
```
Para ejecutar el progrma primero se tiene que correr el ChatServidor en el Paquete Servidor para iniciar el Socket que nos permite conectar con el servidor 
```
java -cp .:Lib/AbsoluteLayout.jar Servidor/ChatServidor
```
Despues, en otra ventana de la terminal, se ejecutan los Clientes que se vayan a utilizar
```
java -cp .:Lib/AbsoluteLayout.jar Cliente/ChatCliente
```

## Construido con 

* [SublimeText 3](https://www.sublimetext.com/) - Editor de Texto
* [Adobe Illustrator](https://www.adobe.com/mx/products/illustrator.html) - Creador de Iconos


## Referencias
− Java Threads, Scott Oaks & Henry Wong, Ed. O'Reilly, 3ª Edición, 2004 − Core Java 2 Vol. 2 – Características Avanzadas, Cay Horstmann & Gary Cornell, Ed. Prentice Hall – Pearson Educación, 7ª Edición, 2005 


## Version
Version 2.5 ClienteServidorHilos

## Autor 
* **Daniel Escobar Araujo** [DanielEscobar21](https://github.com/DanielEscobar21)

## Licencia 
Copyright (c) 2020-Daniel Escobar Araujo (DanielEscobar21)

Por la presente se concede permiso, sin cargo, a cualquier persona que obtenga una copia de este software y los archivos de documentación asociados (el "Software"), para utilizar el Software sin restricciones, incluidos, entre otros, los derechos de uso, copia, modificación, fusión , publicar, distribuir, sublicenciar y / o vender copias del Software, y permitir que las personas a las que se les proporcione el Software lo hagan, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales del Software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIABILIDAD, ADECUACIÓN PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS AUTORES O TITULARES DE LOS DERECHOS DE AUTOR SERÁN RESPONSABLES DE CUALQUIER RECLAMO, DAÑOS U OTRAS RESPONSABILIDADES, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O DE OTRO MODO, QUE SURJA DE, FUERA DE O EN RELACIÓN CON EL SOFTWARE O EL USO U OTRAS NEGOCIACIONES EN EL SOFTWA

## Datos 

* Este Proyecto se hizo en Base a la materia de Tópicos Avanzados de Programación.


