INSERT INTO CATEGORY (TYPE, DESCRIPTION, IMG_URL)
    VALUES
        ('Śniadania', 'Pożywne, sycące przepisy, które sprawią, że twój poranek będzie pełen energi', 'https://resize.indiatvnews.com/en/resize/newbucket/730_-/2022/05/breakfast-1651819066.jpg'),
        ('Obiady domowe', 'Tego możesz nauczyć się od Babci, ale także i z tej strony', 'https://damusia.pl/wp-content/uploads/2019/08/11-16-e1566887739380.jpg'),
        ('Obiady orientalne', 'Chodzisz często na Chińczyka, albo tajskie? Od teraz nie będziesz tego potrzebował', 'https://kulinarnapolska.org/wp-content/uploads/2020/07/kurczak-z-woka-przepis.jpg'),
        ('Desery', 'Jeśli uważasz, że słowo schudnąć nie powinno istnieć w twoim słowniku to śmiało spróbuj tych przepisów', 'https://staticsmaker.iplsc.com/smaker_production_2022_05_31/9aaf710f28a3e2dba37245ab910ce95c-recipe_main.jpg'),
        ('Przekąski', 'Nie zajadaj ich przed głównymi posiłkami! :)', 'https://smakowity.pl/storage/3642/conversions/przekaska-z-biszkoptow-large.jpg'),
        ('Chleby', 'Wiejski chlebek z masełkiem? A może pajda chleba z kiełbasą?', 'https://staticsmaker.iplsc.com/smaker_production_2022_02_17/02b863261ad7c97aaef6840a076a97c7-recipe_main.jpg');

INSERT INTO RECIPE (NAME, PREPARE_TIME, RECIPE_IMG_URL ,CATEGORY_ID, DESCRIPTION, INGREDIENTS, INSTRUCTION, LIKED_RECIPE, DATE)
    VALUES
        ('Omlet z bekonem', 20, 'https://i.wpimg.pl/O/644x429/d.wpimg.pl/1109915733--1015584743/omlet.jpg', 1, 'Proste danie do 6 zł za posiłek jednoosobowy',
         '4 Jajka, 50g Bekonu, garść szczypiorku, 100g mąki', 'przesmaź boczek na patelni, później wymieszaj jajka z mąką, dosól i dopieprz, mieszaj dodając przesmażony boczek,
wrzuć na rozgrzaną patelnię a na końcu posyp szczypiorkiem', 1, '2022-08-01'),
        ('Jajecznica', 15, 'https://www.mojegotowanie.pl/media/cache/default_medium/uploads/media/recipe/0002/11/jajecznica-z-mlekiem.jpeg', 1, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Kotlety mielone z koperkiem', 45, 'https://1.bp.blogspot.com/-uvkMOa9HL1Q/XRdeChmM9RI/AAAAAAAAOzQ/QC7Chx32mFkk_zkC8aMG_tC4GJq0HMwqQCPcBGAYYCw/s1600/kotlety%2Bruskie%2Bz%2Bkoperkiem%2B%25287%2529.JPG', 2, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Barszcz Biały', 60, 'https://www.kwestiasmaku.com/sites/v123.kwestiasmaku.com/files/barszczbialy.jpg', 2, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Kurczak w 5 smakach', 60, 'https://s3.przepisy.pl/przepisy3ii/img/variants/800x0/schab-w-pieciu-smakach182897.jpg', 3,'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Kurczak po Tajlandzku', 60, 'https://euro-sterydy.pl/wp-content/uploads/2020/02/Kurczak-po-tajlandzku.jpeg', 3,'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Naleśniki z dżemem', 25, 'https://poprostupycha.com.pl/wp-content/uploads/2018/05/nalesniki2-1024x682.jpg.webp', 4, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Lody Truskawskowe', 20, 'https://wszystkiegoslodkiego.pl/storage/images/201930/lody-truskawkowo-jogurtowe-z-zwanilia-1.jpg', 4, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Czipsy', 25, 'https://cdn.galleries.smcloud.net/t/galleries/gf-MW4D-juGa-kKRB_domowe-chipsy-ziemniaczane-jak-zrobic-chipsy-w-piekarniku-664x442-nocrop.jpg', 5, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Marcheweczki', 10, 'https://ewawachowicz.pl/przepisy/1340-1.jpg', 5, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Chleb żytni na zakwasie', 120, 'https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/76561bdc-1211-4f8b-8b48-259827352375/Derivates/43f0768c-7844-4d0c-a4e4-71411b09de32.jpg', 6, 'example', 'ingredients', 'instruction', 0, '2022-08-01'),
        ('Chleb wiejski', 120, 'https://www.canalpluskuchnia.pl/wideo/35755-kuchniafrancuska2/odc.6_MiracleBoule.jpg', 6, 'example', 'ingredients', 'instruction', 0, '2022-08-01');

INSERT INTO USER_INFO (LOGIN_NAME, PASSWORD, SUBSCRIBER, FIRST_NAME, LAST_NAME, BIRTHDATE)
    VALUES
        ('test1@test.pl', 'test123', false, 'test1', 'tester1', '2000-08-01'),
        ('test2@test.pl', 'test234', false, 'test2', 'tester2', '2000-09-01'),
        ('test3@test.pl', 'test345', false, 'test3', 'tester3', '2000-10-01');