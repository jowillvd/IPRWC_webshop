# IPRWC_webshop

Webshop voor het kopen van online films, module IPRWC

## Voorbeeld applicatie (DEMO)

http://136.144.177.199/

### Inloggegevens

Inloggegevens Docent:
* docent@hsleiden.nl
* geheim2018

Inloggegevens Student:
* student@hsleiden.nl
* geheim2018

## Te gebruiken URI's client

Toegankelijk zonder login:
* /
* /login
* /registreren
* /films
* /films/{id}
* /films
* /shoppingcart

Enkel toegankelijk met login:
* /mijnfilms
* /mijnfilms/{id}

## Te gebruiken URI's API

Toegankelijk zonder AUTH:
* GET: /api/gebruikers/{id}
* GET: /api/gebruikers/search/{name}
* POST: /api/gebruikers

Enkel toegankelijk met AUTH:
* GET: /api/gebruikers/me
* PUT: /api/gebruikers/{id}
* DELETE: /api/gebruikers/{id}

