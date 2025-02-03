A feladat:

Java és lehetőleg TestNG segítségével írj kérlek egy regisztrációs teszt folyamatot a Budapest13 Smart City mobil
alkalmazásra
(Google Storeban vagy App Storeban is megtalálható).

1. Megnyitja az alkalmazást
2. Regisztrál
3. Az e-mailben található megerősítő linkkel (az e-mailt API-n keresztül érd el)
4. Megerősíti a regisztrációt
5. Leellenőrzi a regisztráció sikerességét

Megjegyzés: Riportot is készítsen a teszt és részletes readme-t is tartalmazzon a projekt.


--------------------------------------------------------------------------------------------

Előfeltételek:

- Emulálni egy android eszközt (1080x2400) API 34, amire telepítve van a Budapest13 applikáció.
    Ehhez Android studiot + UiAutomator2-t + Appium Inspectort használtam

--------------------------------------------------------------------------------------------

Technológiák:

- Cucumber
- TestNG
- Java/Maven
- Appium (& Selenium)
- https://mailsac.com - Mailing

--------------------------------------------------------------------------------------------

Futtatás:

- Futtatsd a TestNGCucumberRunner-t
- A cucumber report megtalálható a futás végén 
(pl:  https://reports.cucumber.io/reports/ffe48248-3ef1-4382-9166-177a3c84b12a)

--------------------------------------------------------------------------------------------

Hiányzó elemek:

- Sikerült megszerezni a megerősítő tokent a return url-lel, viszont elküldéskor 500-at dob vissza