package com.example.geography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4;
    TextView countryView, scoreView, bestScoreView;
    String[] capitals = new String[]{"Абу-Даби", "Абуджа", "Аддис-Абеба", "Аккра", "Алжир", "Амман", "Амстердам", "Андорра-ла-Велья", "Анкаpа", "Антананариву", "Апиа", "Асмэра", "Астана", "Асунсьон", "Афины", "Ашхабад", "Багдад", "Баку", "Бамако", "Банги", "Бангкок", "Бандар-Сери-Бегаван", "Банжул", "Бастер", "Бейрут", "Белград", "Бельмопан", "Берлин", "Берн", "Бисау", "Бишкек", "Богота", "Браззавиль", "Бразилиа", "Братислава", "Бриджтаун", "Брюссель", "Будапешт", "Бужумбура", "Бухарест", "Буэнос-Айрес", "Вадуц", "Валетта", "Варшава", "Ватикан", "Вашингтон", "Веллингтон", "Вена", "Виктория", "Вила", "Вильнюс", "Виндхук", "Вьентьян", "Габороне", "Гавана", "Гватемала", "Дакар", "Дакка", "Дамаск", "Дели", "Джакарта", "Джибути", "Джорджтаун", "Джуба", "Дили", "Додома", "Доха", "Дублин", "Душанбе", "Ереван", "Загреб", "Иерусалим", "Исламабад", "Кабул", "Каир", "Кампала", "Канберра", "Каракас", "Кастри", "Катманду", "Кигали", "Киев", "Кингстаун", "Кингстон", "Киншаса", "Кито", "Кишинев", "Коломбо", "Конакри", "Копенгаген", "Корор", "Куала-Лумпур", "Ла-Пас", "Либревиль", "Лилонгве", "Лима", "Лиссабон", "Ломе", "Лондон", "Луанда", "Лусака", "Любляна", "Люксембург", "Маджуро", "Мадрид", "Малабо", "Мале", "Манагуа", "Манама", "Манила", "Мапуту", "Масеру", "Маскат", "Мбабане", "Мехико", "Минск", "Могадишо", "Монако", "Монровия", "Монтевидео", "Морони", "Москва", "Найроби", "Нассау", "Нджамена", "Нейпьидо", "Ниамей", "Никосия", "Нуакшот", "Нукуалофа", "Осло", "Оттава", "Паpамаpибо", "Паликир", "Панама", "Париж", "Пекин", "Пномпень", "Подгорица", "Порт-Луи", "Порт-Морсби", "Порт-о-Пренс", "Порт-оф-Спейн", "Порто-Ново", "Прага", "Прая", "Претория", "Пхеньян", "Рабат", "Рамалла", "Рейкьявик", "Рига", "Рим", "Розо", "Сан-Марино", "Сан-Сальвадор", "Сан-Томе", "Сан-Хосе", "Сана", "Санто-Доминго", "Сантьяго", "Сараево", "Сент-Джонс", "Сент-Джорджес", "Сеул", "Сингапур", "Скопье", "София", "Стокгольм", "Сува", "Тайпей", "Таллинн", "Тарава", "Ташкент", "Тбилиси", "Тегеран", "Тегусигальпа", "Тирана", "Токио", "Триполи", "Тунис", "Тхимпху", "Уагадугу", "Улан-Батор", "Фpитаун", "Фунафути", "Хаpтум", "Ханой", "Хараре", "Хельсинки", "Хониаpа", "Эль-Кувейт", "Эр-Рияд", "Ямусукро", "Ярен", "Яунде"};
    String[] countries = new String[]{"ОАЭ", "Нигерия", "Эфиопия", "Гана", "Алжир", "Иордания", "Нидерланды", "Андорра", "Турция", "Мадагаскар", "Самоа", "Эритрея", "Казахстан", "Парагвай", "Греция", "Туркмения", "Ирак", "Азербайджан", "Мали", "Центральноафриканская Республика", "Таиланд", "Бруней", "Гамбия", "Сент-Кристофер и Невис", "Ливан", "Сербия", "Белиз", "Германия", "Швейцария", "Гвинея-Бисау", "Киргизия", "Колумбия", "Конго", "Бразилия", "Словакия", "Барбадос", "Бельгия", "Венгрия", "Бурунди", "Румыния", "Аргентина", "Лихтенштейн", "Мальта", "Польша", "Ватикан", "США", "Новая Зеландия", "Австрия", "Сейшельские острова", "Вануату", "Литва", "Намибия", "Лаос", "Ботсвана", "Куба", "Гватемала", "Сенегал", "Бангладеш", "Сирия", "Индия", "Индонезия", "Джибути", "Гайана", "Южный Судан", "Восточный Тимор", "Танзания", "Катар", "Ирландия", "Таджикистан", "Армения", "Хорватия", "Израиль", "Пакистан", "Афганистан", "Египет", "Уганда", "Австралия", "Венесуэла", "Сент-Люсия", "Непал", "Руанда", "Украина", "Сент-Винсент и Гренадины", "Ямайка", "Конго (Дем. Република)", "Эквадор", "Молдавия", "Шри-Ланка", "Гвинея", "Дания", "Палау", "Малайзия", "Боливия", "Габон", "Малави", "Перу", "Португалия", "Того", "Великобритания", "Ангола", "Замбия", "Словения", "Люксембург", "Маршалловы острова", "Испания", "Экваториальная Гвинея", "Мальдивы", "Никарагуа", "Бахрейн", "Филиппины", "Мозамбик", "Лесото", "Оман", "Эсватини", "Мексика", "Белоруссия", "Сомали", "Монако", "Либерия", "Уругвай", "Коморские острова", "Российская Федерация", "Кения", "Багамские острова", "Чад", "Мьянма", "Нигер", "Кипр", "Мавритания", "Тонга", "Норвегия", "Канада", "Суринам", "Микронезия", "Панама", "Франция", "Китай", "Камбоджа", "Черногория", "Маврикий", "Папуа - Новая Гвинея", "Гаити", "Тринидад и Тобаго", "Бенин", "Чехия", "Кабо-Верде", "ЮАР", "Корея Северная", "Марокко", "Палестина", "Исландия", "Латвия", "Италия", "Доминика", "Сан-Марино", "Сальвадор", "Сан-Томе и Принсипи", "Коста-Рика", "Йемен", "Доминиканская Республика", "Чили", "Босния и Герцеговина", "Антигуа и Барбуда", "Гренада", "Корея Южная", "Сингапур", "Северная Македония", "Болгария", "Швеция", "Фиджи", "Тайвань", "Эстония", "Кирибати", "Узбекистан", "Грузия", "Иран", "Гондурас", "Албания", "Япония", "Ливия", "Тунис", "Бутан", "Буркина-Фасо", "Монголия", "Сьерра-Леоне", "Тувалу", "Судан", "Вьетнам", "Зимбабве", "Финляндия", "Соломоновы острова", "Кувейт", "Саудовская Аравия", "Кот-д'Ивуар", "Науру", "Камерун"};
    Button rightButton;
    int score = 0, bestScore = 0;
    SharedPreferences savedBestScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        countryView = findViewById(R.id.mainTextView);
        scoreView = findViewById(R.id.scoreTextView);
        bestScoreView = findViewById(R.id.bestScoreTextView);
        savedBestScore = getSharedPreferences("bestScore", MODE_PRIVATE);
        loadBestScore();

        rightButton = createQuestion();
        View.OnClickListener listener = v -> {
            int delay;
            Button curB = findViewById(v.getId());

            Handler handler = new Handler();
            if (rightButton == curB){
                curB.setBackgroundColor(getResources().getColor(R.color.green));
                score++;
                delay = 500;
            }
            else{
                if (score > bestScore) newBest();
                curB.setBackgroundColor(getResources().getColor(R.color.red));
                rightButton.setBackgroundColor(getResources().getColor(R.color.green));
                score = 0;
                delay = 1500;
            }
            handler.postDelayed(() ->{
                b1.setBackgroundColor(getResources().getColor(R.color.white));
                b2.setBackgroundColor(getResources().getColor(R.color.white));
                b3.setBackgroundColor(getResources().getColor(R.color.white));
                b4.setBackgroundColor(getResources().getColor(R.color.white));
                rightButton = createQuestion();
            }, delay);
            scoreView.setText(Integer.toString(score));
            bestScoreView.setText(bestScore + " - Рекорд");
        };
        b1.setOnClickListener(listener);
        b2.setOnClickListener(listener);
        b3.setOnClickListener(listener);
        b4.setOnClickListener(listener);
    }
    private void newBest(){
        bestScore = score;
        SharedPreferences.Editor ed = savedBestScore.edit();
        ed.putString("bestScore", Integer.toString(bestScore));
        ed.apply();
    }
    private void loadBestScore(){
        String bsStr = savedBestScore.getString("bestScore", "0");
        bestScore = Integer.parseInt(bsStr);
        bestScoreView.setText(bsStr + " - Рекорд");
    }
    private Button createQuestion(){
        Random rand = new Random();
        int countryNumber = rand.nextInt(countries.length - 1);
        int b1Num, b2Num, b3Num, b4Num;
        Button[] buttons = new Button[]{b1, b2, b3, b4};
        do {
            b1Num = rand.nextInt(countries.length);
        }while (b1Num == countryNumber);
        do {
            b2Num = rand.nextInt(countries.length);
        }while (b2Num == countryNumber || b2Num == b1Num);
        do {
            b3Num = rand.nextInt(countries.length);
        }while (b3Num == countryNumber || b3Num == b1Num || b3Num == b2Num);
        do {
            b4Num = rand.nextInt(countries.length);
        }while (b4Num == countryNumber || b4Num == b1Num || b4Num == b2Num | b4Num == b3Num);

        countryView.setText(countries[countryNumber]);

        buttons[0].setText(capitals[b1Num]);
        buttons[1].setText(capitals[b2Num]);
        buttons[2].setText(capitals[b3Num]);
        buttons[3].setText(capitals[b4Num]);

        int rightButtonNumber = rand.nextInt(4);
        buttons[rightButtonNumber].setText(capitals[countryNumber]);

        editButtons();
        return buttons[rightButtonNumber];
    }
    private void editButtons(){
        changeTextButtonSize(b1);
        changeTextButtonSize(b2);
        changeTextButtonSize(b3);
        changeTextButtonSize(b4);
    }
    private void changeTextButtonSize(Button b){
        if (b.getText().length() > 15)
            b.setTextSize(8);
        else if (b.getText().length() > 13)
            b.setTextSize(9);
        else if (b.getText().length() > 11)
            b.setTextSize(10);
        else if (b.getText().length() > 9)
            b.setTextSize(11);
        else if (b.getText().length() > 7)
            b.setTextSize(13);
        else
            b.setTextSize(14);
    }
}