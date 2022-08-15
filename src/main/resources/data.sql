INSERT INTO RECIPE_CATEGORY (TYPE, DESCRIPTION, URL_CATEGORY)
    VALUES
        ('Śniadania', 'Pożywne, sycące przepisy, które sprawią, że twój poranek będzie pełen energi', 'https://resize.indiatvnews.com/en/resize/newbucket/730_-/2022/05/breakfast-1651819066.jpg'),
        ('Obiady domowe', 'Tego możesz nauczyć się od Babci, ale także i z tej strony', 'https://damusia.pl/wp-content/uploads/2019/08/11-16-e1566887739380.jpg'),
        ('Obiady orientalne', 'Chodzisz często na Chińczyka, albo tajskie? Od teraz nie będziesz tego potrzebował', 'https://kulinarnapolska.org/wp-content/uploads/2020/07/kurczak-z-woka-przepis.jpg'),
        ('Desery', 'Jeśli uważasz, że słowo schudnąć nie powinno istnieć w twoim słowniku to śmiało spróbuj tych przepisów', 'https://staticsmaker.iplsc.com/smaker_production_2022_05_31/9aaf710f28a3e2dba37245ab910ce95c-recipe_main.jpg'),
        ('Przekąski', 'Nie zajadaj ich przed głównymi posiłkami! :)', 'https://smakowity.pl/storage/3642/conversions/przekaska-z-biszkoptow-large.jpg'),
        ('Chleby', 'Wiejski chlebek z masełkiem? A może pajda chleba z kiełbasą?', 'https://staticsmaker.iplsc.com/smaker_production_2022_02_17/02b863261ad7c97aaef6840a076a97c7-recipe_main.jpg');

INSERT INTO RECIPE (NAME, RECIPE_CATEGORY_ID)
    VALUES
        ('Omlet z bekonem', 1),
        ('Jajecznica', 1),
        ('Kotlety mielone z koperkiem', 2),
        ('Barszcz Biały', 2),
        ('Kurczak w 5 smakach', 3),
        ('Kurczak po Tajlandzku', 3),
        ('Naleśniki z dżemem', 4),
        ('Lody Truskawskowe', 4),
        ('Czipsy', 5),
        ('Marcheweczki', 5),
        ('Chleb żytni na zakwasie', 6),
        ('Chleb wiejski', 6);

INSERT INTO RECIPE_DESCRIPTION (DESCRIPTION, INGREDIENTS, INSTRUCTION, DATE, RECIPE_ID)
    VALUES
        ('example', 'ingredients', 'instruction', '2022-08-01', 1),
        ('example', 'ingredients', 'instruction', '2022-08-01', 2),
        ('example', 'ingredients', 'instruction', '2022-08-01', 3),
        ('example', 'ingredients', 'instruction', '2022-08-01', 4),
        ('example', 'ingredients', 'instruction', '2022-08-01', 5),
        ('example', 'ingredients', 'instruction', '2022-08-01', 6),
        ('example', 'ingredients', 'instruction', '2022-08-01', 7),
        ('example', 'ingredients', 'instruction', '2022-08-01', 8),
        ('example', 'ingredients', 'instruction', '2022-08-01', 9);