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

#### Inteligentne klasyfikatory
TODO

#### SVM Maszyny wektorów wspierających

#### Walidacja, walidacja krzyżowa
Walidacja - dla danych treningowych obliczamy błąd funkcji hipotezy (błąd odpowiedzi). Na podstawie błędu możemy korygować parametry funkcji hipotezy.

Walidacja krzyżowa - zbiór danych dzielimy na 3 części: zbior treningowy, zbiór walidacyjny, zbiór testowy. Zbiór testowy służy do oszacowania poprawności wybranego modelu. Zbiory testowe i walidacyjne do oszacowania błędu badanego modelu.


#### Drzewa decyzyjne i ich nauka
Zachłanna selekcja cech w przód - można liczyć miarę uporządkowania za pomocą indeksu Giniego lub entropi. Na pierwszą cechę do podziału brać tą, która prezentuje miarę uporządkowania największą. Następnie zbior danych pomniejszamy o wybraną cechę i konstrujemy drzewo rekruencyjnie dla każdej gałęzi osobno.

#### Naiwny Bayes
Jest naiwny gdyż zakłada niezależnośc cech.

#### Złożoność obliczeniowa
Ilość zasobów komputerowych potrzebnych do wykonania programu
* Pesymistyczna - zużycie zasobów dla najmniej korzystnego zestawu danych
* Średnia - zużycie zasobów dla danych losowych
* Optymistyczna - zużycie zasobów dla najbardziej korzystnych danych

#### Strategie algorytmów
* Dziel i rządź - dzielenie problemu na mniejsze podproblemy rekurencyjnie do czasu aż dany podproblem staje się wystarczająco prosty do rozwiązania. Np. Merge stort
* Programowanie dynamiczne - rozszerzenie schematu dziel i rządź. Przydane gdy dane nie są od siebie niezależne. Oznacza to, że raz rozwiązany podproblem nie jest rozwiązywany poraz drugi, lecz brany z tabeli gdzie został wcześniej zapamiętany (cache).

#### Programownie masowo-równoległe
Programowanie GPU polega na podzieleniu wielu operacji na shadery (jednostki obliczeniowe - shader jest odpowiedzialny za wyświetlanie piksela na ekranie, może być wykorzystany do innych zadań), które są wykonywane równolegle przez każdy wątek karty graficznej. Shader traktujemy jako program.
Wady:
* Ograniczenie ze względu na liczby zmienno przecinkowe
* Konieczna znajomość API: OpenGL, OpenCL, CUDA
* GPU posiada osobną pamięć więc czasami dane muszą być przeniesione do RAM

#### Warstwowa budowa aplikacji internetowych - MVC
* Model - odpowiada za modelowanie problemu domenowego, często jest to reprezentacja danych
* View - Warstwa prezentacji, interfejs użytkownika
* Controller - odpowiedzialny za kontrolowanie przepływu danych z modelu do widoku i odwrotnie

#### SOAP i Restful
* SOAP (Simple Object Access Protocol) - oparty na formacie XML. Komunikat składa się z: Envelope(początek, koniec wiadomości, obowiazkowy), Header(parametry opcjonalne, opcjonalny), Body(zawartosc wiadomosci, obowiazkowy). SOAP z definicji jest bardzo formalny – tzn. każdy serwis powinien udostępniać plik WSDL, który opisuje jak się nazywa każda operacja, jakie dane przyjmuje, jakiego typu są to dane itp

* RESTful - architektura komunikacji, oparta na protokole HTTP. REST jest bezstanowy i bazuje na metodach HTTP: GET, PUT, POST, TRACE, DELETE etc.

#### Liniowa i nieliniowa filtracja obrazu
* Filtry  liniowe - bazują na  operacjach  liniowych  (łatwiejsze  w  realizacji). Mogą służyć do wyostrzania obrazu, bądź detekcji krawędzi.
* Filtry nieliniowe - bazują na nieliniowych operacjach np. operacje logiczne.  Użyteczne do poprawy jakości obrazu bądź redukcji szumów.
