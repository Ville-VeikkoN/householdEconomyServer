# Household economy
## Project contains domain objects for simple Spring boot back-end

### Assigment (in Finnish)
1. Suunnittele / toteuta liiketoimintaluokat (http://c2.com/cgi/wiki?DomainObject) pieneen järjestelmään, jossa ylläpidetään luonnollisen henkilön perustietoja (tyyliin Väestötietojärjestelmä, https://dvv.fi/vaestotietojarjestelma)
* Java back-end
* termien kieli suomi tai englanti
* max. viisi luokkaa, max. kymmenen attribuuttia / luokka
* mahdollisten liiketoimintametodien toiminnallisuutta ei tarvitse toteuttaa loppuun
* ei tietokantakäsittelyä (JPA tms.)
* ei tarvita käynnistyvää sovellusta, vain liiketoimintaluokat (ja tarvittavat apuluokat)
* toiminnallisuuksia voi soveltuvin osin demota vaikka Junit-testeillä

### Own observations about assignment (in Finnish)
Toteutin tehtävän luomalla liiketoimintaluokat kuvitteelliseen järjestelmään jonka kautta voidaan hakea luonnollisten henkilöiden perustietoja sekä tuloja / menoja. Kuvitteellisessä järjestelmässä on myös tieto ruokakunnista ja niiden kokonaistuloista (aikuisten) sekä lainanhoitomenoista. Järjestelmää varmasti käyttäisi (jos sellainen voisi tosielämässä olla) asuntovelalliset hakemaan "vertaistukea" kasvavien korkojen maailmassa sekä mahdollisesti esim. kunnat hakiessaan tietoja ihmisten nykyisien asuinkuntien/asuinmuotojen ja heidän työkuntien/tulojen suhteita.

Validoinnin toteutin tässä kohtaa vain Person-luokalle, nämä tietysti tulisi huomioida myös muiden liiketoimintaluokkien kohdalla. Koodin paremman luottavuuden vuoksi hyödynnän luokissa Lombokin (https://projectlombok.org/) ```@Data``` annotaatiota, joka generoi ```get```, ```set```, ```toString```, ```equals``` ja ```hashCode``` -metodit. Luokkien toiminnallisuuksien testaaminen on toteutettu PersonTest.java -luokkaan kootusti. Javadoceja ei toteutettu tämän tehtävän luokille. 

**HUOM: Ohjeistus rajasi luokkien määärän viiteen, tässä tapauksessa en laskenut Enumeraatioita luokiksi!**

# UML Class diagram:

![DOM (9)](https://user-images.githubusercontent.com/36700188/221427273-c541c1e1-e3b2-488e-a16c-7584f1207ae4.jpeg)
