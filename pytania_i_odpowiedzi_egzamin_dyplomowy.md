#### Analiza systemów informatycznych, dokument wizji, potrzeby i wymagania użytkownika
* Dokument wizji - jest odpowiedzialny za zdefiniowanie **dlaczego** i **dla kogo** dany projekt informatyczny jest realizowany. Powininen definiować sponsorów projektu, użytkowników, wykonawców ogólnie stakeholderów. Dodatkowo może definiować wymagania, które muszą zostać spełnione podczas projektu (standardy podczas wytwarzania oprogramowania), wymagane platformy, na których musi być uruchomione oprogramowanie.

* Potrzeby i wymagania użytkownika:
  1. Wymaganie - potrzeba klienta, która wpływa na to, że dany produkt na powstać.
  2. Wymagania biznesowe - co ma być stworzone aby dostarczyć wartość.
  3. Wymagania funkcjonalne - definiują co system informatczny powinien móc robić a czego nie. Jest to de facto zbiór funkcjonalności przewidzianych dla użytkownika.
  4. Wymagania niefunkcjonalne - wymagania jakościowe np. możliwość integracji z innymi systemami, podatność na testowanie, wydajność systemu informatycznego.

#### Proces testowania oprogramowania, rodzaje testów
1. Testy jednostkowe (unit testy)
2. Testy integracyjne komponetnów
3. Testy E2E
4. Testy obciążeniowe (czy system wytrzyma zadane obciążenie)
5. Stress testy (czy system dany zachowa się odpowiednio podczas zbyt dużego obciążenia systemu).
6. Testy white box (z uwzględnieniem implementacji oprogramowania)
7. Testy black box (testujemy tylko interfejs użytkownika, traktujemy oprogramowanie jak czarną skrzynkę, często sprowadza się do testowania manualnego)
8. Testy akceptacyjne

#### Rational Unified Process
Iteracyjny proces wytwarzania oprogramowania. Jest to szablon, który może być adaptowany na potrzeby danej organizacji, projektu, zespołu. Składa się z faz:
1. faza rozpoczęcia (Inception phase)
2. faza opracowywania (Elaboration phase)
3. faza konstrukcji (Construction phase)
4. faza przekazania systemu (Transition phase)

#### Zwinne metody wytwarzania oprogramowania
Bliski kontakt z klientem, samozarządzalny zespół, prostota, ciągła ewaluacja wymagań, dążenie do satysfakcji klienta zamiast podążanie za wyznaczonym planem, podstawową miarą postępu jest działające oprogramowanie.

Xtreme programming
TDD
Scrum

#### Scrum
The team (SM + developerzy ), The Scrum Team (PO + SM + developerzy), Backlog, iteracje, interdyscyplinarny zespół, user stories
> wymagania -> analiza -> planowanie -> kodowanie -> testowanie -> deployment

#### Zwinne estymaty
Zazwyczaj są to liczby ciągu fibonnaciego 0.5, 1, 2, 3, 5, 8, 13, 20, 40, 100. Wyrażają one stopień skomplikowania zadania, jak również czasochłonność.
Velocity - jak dużo story pointów może dostarczyć zespół w iteracji (można policzyć po 11 sprintach)
Capacity - jaka ilość czasu jest dostępna w sprincie, pomaga w zaplanowaniu ile stories może być wzięte do sprintu.
