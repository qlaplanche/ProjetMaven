# TD - Maven 

Par Quentin Laplanche.
----


## Partie 1:

- ### Exercice 16

    - Comme le stagiaire a modifié le code. Celui-ci ne passe plus les tests unitaires que nous avons écrits.
Maven nous affiche donc : `on project ql: There are test failures.` et refuse de faire une release.

## Partie 2:

- ### Exercice 23 
```Java
    java -jar target/marelease.jar
Hello World!
Résultat : 5
Exception in thread "main" java.lang.NoClassDefFoundError: com/opencsv/CSVReader
        at ql.App.main(App.java:19)
Caused by: java.lang.ClassNotFoundException: com.opencsv.CSVReader
        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
        ... 1 more
```


## Partie 3 

- ### Exercice 31 
    - Dans le fichier produit, les nombres sont entourés de guillemets, ce qui est problématique pour un fichier csv. On peut résoudre le problème en passant false pour le param `applyQuotesToAll` qui vaut true par défault.
```Java
writer.writeNext(out.toArray(new String[0]), false);
```