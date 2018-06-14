# CalculProject

CalculProject è un'applicazione per Android che può risolvere espressioni in notazione suffissa, infissa e prefissa.
Sono disponibili una [Wiki](https://github.com/cristinaochner/CalculProject/wiki) e un sistema di [bug tracking](https://github.com/cristinaochner/CalculProject/issues) pubblici.

### Sulle notazioni..:

La notazione infissa è la classica notazione a cui siamo abituati:
```
 3  *  2  +  5  *  3 
 6  +  15 
 21
```
La notazione suffissa o 'Polacca Inversa' (RPN) pone gli operatori dopo gli operandi:
```
 3  2  *  5  3  *  +
 6  5  3  *  +
 6 15  +
 21
 ```
La notazione prefissa è l'opposto della precedente:
```
 +  *  3  2  *  5  3  
 +  6 15
 21
 ```

Il repository contiene un progetto per 
[![N|Solid](https://developer.android.com/studio/images/home/android-studio-logo.svg)]()
