# Projecte-caixerAutomatic-Asier
**Índex continguts**

El projecte de M03 que he creat, com es demanava, es un caixer automàtic desenvolupat amb Java i JavaFX. Aquest programa permet als usuaris poder fer login: En iniciar l'aplicació demanarà l'identificador d'usuari i la contrasenya, si tot està correcte, contínua l'aplicació i mostrarà el menú d'opcions; en cas contrari donarà un missatge d'error i no es pot operar. L'Usuari té 3 intents per fer bé el login, si esgota tots els intents, l'usuari es bloqueja.

Els clients dels banc disposaran d’un o diversos comptes. Els comptes podran ser de dos tipus: comptes corrents o comptes d’estalvis. Els comptes d’estalvis tenen un tipus d’interès més elevat i els comptes corrents podran tenir targetes associades.

Dintre del menú es pot accedir a les diferents aplicacions que té el caixer: Consultar saldo, transferència, ingressar, retirar, préstec, dipòsit, consultar moviments, cambiar compte, tarjeta, informació, canviar clau d'accés i tancar compte.

Els diferents moviments que ha fet el client en un dels seus comptes podran ser consultats en la classe de "moviments" on de cada moviment es sap: el tipus d'ingrés, transferència, la data, quantitat diners implicats, etc.

El caixer opera únicament amb bitllets, i en disposa d’una certa quantitat de cada un d’ells. Les operacions d’extracció i d'ingrés afecten a la quantitat de diners emmagatzemada en el caixer. Quan es fan operacions d’extracció es comprova que l’operació sigui possible segons els bitllets disponibles. 

He implementat 3 funcionalitats extra al caixer que en aquest cas són: Dipòsit, préstec i cambiar de compte.

-------------------------------------------------------

**Diagrama de classes**

El diagrama de classes es troba dintre del projecte, igualment aporto l'enllaç per poder accedir: https://drive.google.com/file/d/17YaAGxiOpyuC4w8WYnnDJGTZRc3A6uj5/view?usp=sharing

-------------------------------------------------------

**Descripció de les funcionalitats implementades**

He implementat les següents funcions:

App, banc, bitllets, un controlador de bitllets, caixer, comptes, dipòsit, controlador per al dipòsit, un apartat extra d'informació, una classe per ingressar, login, moviment, un controlador de moviments, préstec, un controlador de préstec, el primary controller, retirar diners, controlador de saldo, el secondary controller, una tarjeta, el controlador de la tarjeta, transferencia, el controlador de transferencia, usuari i per últim canvi clau accés.

Dintre, els arxius están comentats amb JavaDoc on s'explica de manera clara com funciona cada classe i la seva funció corresponent.
