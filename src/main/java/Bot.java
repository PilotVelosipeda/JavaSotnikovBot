import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    //Для открытия сессии для работы с БД
//    StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
//            .configure("hibernate.cfg.xml").build();
//    Metadata metadata = new MetadataSources(standardServiceRegistry)
//            .getMetadataBuilder()
//            .build();
//    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
//            .build();
//    Session session = sessionFactory.openSession();
//    Transaction transaction = (Transaction) session.beginTransaction();

    public InlineKeyboardButton back = InlineKeyboardButton.builder()
            .text("Назад")
            .callbackData("назад")
            .build();
    public InlineKeyboardButton moduleOne = InlineKeyboardButton.builder()
            .text("Вводный модуль")
            .callbackData("вводный модуль")
            .build();

    public InlineKeyboardButton whatArePrograms = InlineKeyboardButton.builder()
            .text("Какие бывают программы")
            .callbackData("какие бывают программы")
            .build();

    public InlineKeyboardButton webAppFrontAndBack = InlineKeyboardButton.builder()
            .text("Веб-приложения. Frontend и backend")
            .callbackData("веб-приложения. Frontend и backend")
            .build();

    public InlineKeyboardButton goalsAndAreaApplicationJava = InlineKeyboardButton.builder()
            .text("Цели и области применения Java")
            .callbackData("цели и области применения Java")
            .build();

    public InlineKeyboardButton howLooksProgrammingCode = InlineKeyboardButton.builder()
            .text("Как выглядит программный код")
            .callbackData("как выглядит программный код")
            .build();

    public InlineKeyboardButton downloadIntellijIdea = InlineKeyboardButton.builder()
            .text("Скачать среду разработки")
            .callbackData("скачать среду разработки")
            .url("https://www.jetbrains.com/ru-ru/idea/download/?section=windows")
            .build();

    public InlineKeyboardButton whiteSimpleApp = InlineKeyboardButton.builder()
            .text("Пишем простое приложение")
            .callbackData("пишем простое приложение")
            .build();

    public InlineKeyboardButton jarFile = InlineKeyboardButton.builder()
            .text("Упаковка jar-файла")
            .callbackData("упаковка jar-файла")
            .url("https://docs.google.com/document/d/1YM1mylggI9d1ZkxenWfHRGxn_NK38FJ-1JrHj2eeR1E/edit#heading=h.9yiytdaelm8b")
            .build();

    public InlineKeyboardButton featuresJava = InlineKeyboardButton.builder()
            .text("Особенности языка Java")
            .callbackData("особенности языка Java")
            .build();

    public InlineKeyboardButton practiceWorkModuleOne = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Вводный модуль")
            .build();

    public InlineKeyboardButton moduleTwo = InlineKeyboardButton.builder()
            .text("Синтаксис языка, часть 1")
            .callbackData("синтаксис языка, часть 1")
            .build();
    public InlineKeyboardButton variables = InlineKeyboardButton.builder()
            .text("Переменные")
            .callbackData("переменные")
            .build();
    public InlineKeyboardButton ifAndElseIf = InlineKeyboardButton.builder()
            .text("Условные операторы “if”и “else”")
            .callbackData("условные операторы “if”и “else”")
            .build();

    public InlineKeyboardButton booleanOperation = InlineKeyboardButton.builder()
            .text("Булевы операции")
            .callbackData("булевы операции")
            .build();

    public InlineKeyboardButton priorityAndStaplesInConditions = InlineKeyboardButton.builder()
            .text("Приоритеты и скобки в условиях")
            .callbackData("приоритеты и скобки в условиях")
            .build();

    public InlineKeyboardButton nestedConditions = InlineKeyboardButton.builder()
            .text("Вложенные условия")
            .callbackData("вложенные условия")
            .build();

    public InlineKeyboardButton threeOperator = InlineKeyboardButton.builder()
            .text("Тернарный оператор")
            .callbackData("тернарный оператор")
            .build();

    public InlineKeyboardButton commentsInCode = InlineKeyboardButton.builder()
            .text("Комментарии в коде")
            .callbackData("комментарии в коде")
            .build();

    public InlineKeyboardButton codeMakeApp = InlineKeyboardButton.builder()
            .text("Разбираем код готового приложения")
            .callbackData("разбираем код готового приложения")
            .build();

    public InlineKeyboardButton practiceWorkModuleTwo = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по с я часть 1")
            .build();

    public InlineKeyboardButton moduleThree = InlineKeyboardButton.builder()
            .text("Синтаксис языка, часть 2")
            .callbackData("синтаксис языка, часть 2")
            .build();
    public InlineKeyboardButton cycleFor = InlineKeyboardButton.builder()
            .text("Цикл “for”")
            .callbackData("цикл “for”")
            .build();
    public InlineKeyboardButton cycleWhileAndDoWhile = InlineKeyboardButton.builder()
            .text("Циклы “while” и “do while”")
            .callbackData("циклы “while” и “do while”")
            .build();

    public InlineKeyboardButton switchCase = InlineKeyboardButton.builder()
            .text("Оператор “switch … case”")
            .callbackData("оператор “switch … case”")
            .build();

    public InlineKeyboardButton difficultCode = InlineKeyboardButton.builder()
            .text("Разбираем сложный код")
            .callbackData("разбираем сложный код")
            .build();

    public InlineKeyboardButton workLocalRepository = InlineKeyboardButton.builder()
            .text("Работа с локальным репозиторием")
            .callbackData("работа с локальным репозиторием")
            .build();

    public InlineKeyboardButton practiceWorkModuleThree = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по с я часть 2")
            .build();

    public InlineKeyboardButton moduleFour = InlineKeyboardButton.builder()
            .text("Методы и классы")
            .callbackData("методы и классы")
            .build();

    public InlineKeyboardButton methods = InlineKeyboardButton.builder()
            .text("Методы")
            .callbackData("методы")
            .build();

    public InlineKeyboardButton parametersMethods = InlineKeyboardButton.builder()
            .text("Параметры методов")
            .callbackData("параметры методов")
            .build();

    public InlineKeyboardButton returnsValues = InlineKeyboardButton.builder()
            .text("Возвращаемые значения")
            .callbackData("возвращаемые значения")
            .build();

    public InlineKeyboardButton classAndObjects = InlineKeyboardButton.builder()
            .text("Классы и объекты")
            .callbackData("классы и объекты")
            .build();

    public InlineKeyboardButton constructors = InlineKeyboardButton.builder()
            .text("Конструкторы")
            .callbackData("конструкторы")
            .build();

    public InlineKeyboardButton overloadMethods = InlineKeyboardButton.builder()
            .text("Перегрузка методов")
            .callbackData("перегрузка методов")
            .build();

    public InlineKeyboardButton areaVisibility = InlineKeyboardButton.builder()
            .text("Области видимости")
            .callbackData("области видимости")
            .build();

    public InlineKeyboardButton practiceWorkModuleFour = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Методы и классы")
            .build();

    public InlineKeyboardButton moduleFive = InlineKeyboardButton.builder()
            .text("Инкапсуляция")
            .callbackData("инкапсуляция")
            .build();

    public InlineKeyboardButton encapsulation = InlineKeyboardButton.builder()
            .text("Инкапсуляция")
            .callbackData("инкапсуляция")
            .url("https://blog.skillfactory.ru/glossary/inkapsulyacziya/")
            .build();
    public InlineKeyboardButton pojo = InlineKeyboardButton.builder()
            .text("POJO-классы, геттеры и сеттеры")
            .callbackData("POJO-классы, гет и сет")
            .build();

    public InlineKeyboardButton immutable = InlineKeyboardButton.builder()
            .text("Immutable-классы")
            .callbackData("immutable-классы")
            .build();

    public InlineKeyboardButton linkOrValue = InlineKeyboardButton.builder()
            .text("Передача по ссылке или по значению")
            .callbackData("ссылка или значение")
            .build();

    public InlineKeyboardButton copyObjects = InlineKeyboardButton.builder()
            .text("Копирование объектов")
            .callbackData("копирование объектов")
            .build();

    public InlineKeyboardButton practiceWorkModuleFive = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Инкапсуляция")
            .build();

    public InlineKeyboardButton moduleSix = InlineKeyboardButton.builder()
            .text("Static, константы и enum")
            .callbackData("static, константы и enum")
            .build();
    public InlineKeyboardButton staticVariables = InlineKeyboardButton.builder()
            .text("Статические переменные")
            .callbackData("cтатические переменные")
            .build();
    public InlineKeyboardButton staticMethods = InlineKeyboardButton.builder()
            .text("Статические методы")
            .callbackData("cтатические методы")
            .build();
    public InlineKeyboardButton constants = InlineKeyboardButton.builder()
            .text("Константы")
            .callbackData("константы")
            .build();
    public InlineKeyboardButton Enum = InlineKeyboardButton.builder()
            .text("Enum")
            .callbackData("enum")
            .build();
    public InlineKeyboardButton staticInitialization = InlineKeyboardButton.builder()
            .text("Статическая инициализация")
            .callbackData("cтатическая инициализация")
            .build();
    public InlineKeyboardButton practiceWorkModuleSix = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по static, константы и enum")
            .build();
    public InlineKeyboardButton moduleSeven = InlineKeyboardButton.builder()
            .text("Примитивы")
            .callbackData("примитивы")
            .build();
    public InlineKeyboardButton primitivesAndObjects = InlineKeyboardButton.builder()
            .text("Примитивы и обекты")
            .callbackData("примитивы и обекты")
            .build();
    public InlineKeyboardButton typesOfPrimitives = InlineKeyboardButton.builder()
            .text("Виды примитивов")
            .callbackData("виды примитиво")
            .build();
    public InlineKeyboardButton bitsAndBytes = InlineKeyboardButton.builder()
            .text("Биты и байты")
            .callbackData("биты и байты")
            .build();
    public InlineKeyboardButton Numbers = InlineKeyboardButton.builder()
            .text("Числа")
            .callbackData("числа")
            .build();
    public InlineKeyboardButton symbols = InlineKeyboardButton.builder()
            .text("Символы")
            .callbackData("символы")
            .build();
    public InlineKeyboardButton wrapperClasses = InlineKeyboardButton.builder()
            .text("Классы-обертки")
            .callbackData("классы-обертки")
            .build();
    public InlineKeyboardButton practiceWorkModuleSeven = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Примитивам")
            .build();

    public InlineKeyboardButton moduleEight = InlineKeyboardButton.builder()
            .text("Числа и даты")
            .callbackData("числа и даты")
            .build();
    public InlineKeyboardButton operationsWithNumbers = InlineKeyboardButton.builder()
            .text("Операции с числами")
            .callbackData("операции с числами")
            .build();

    public InlineKeyboardButton moduleNine = InlineKeyboardButton.builder()
            .text("Строки")
            .callbackData("строки")
            .build();
    public InlineKeyboardButton moduleTen = InlineKeyboardButton.builder()
            .text("Массивы и списки")
            .callbackData("массивы и списки")
            .build();
    public InlineKeyboardButton moduleEleven = InlineKeyboardButton.builder()
            .text("Коллекции Set,Map")
            .callbackData("коллекции Set,Map")
            .build();
    public InlineKeyboardButton moduleTwelve = InlineKeyboardButton.builder()
            .text("Comparator iterator Collections")
            .callbackData("c i Collections")
            .build();
    public InlineKeyboardButton moduleThirteen = InlineKeyboardButton.builder()
            .text("Наследование")
            .callbackData("наследование")
            .build();
    public InlineKeyboardButton moduleFourteen = InlineKeyboardButton.builder()
            .text("Абстрактные классы и интерфейсы")
            .callbackData("абстрактные классы и интерфейсы")
            .build();
    public InlineKeyboardButton moduleFifteen = InlineKeyboardButton.builder()
            .text("Deployment")
            .callbackData("deployment")
            .build();
    public InlineKeyboardButton moduleSixteen = InlineKeyboardButton.builder()
            .text("Функциональное програмирование в Java.ч.1")
            .callbackData("ф п в Java.ч.1")
            .build();
    public InlineKeyboardButton moduleSeventeen = InlineKeyboardButton.builder()
            .text("Функциональное програмирование в Java.ч.2.Stream API")
            .callbackData("ф п в Java.ч.2.Stream API")
            .build();
    public InlineKeyboardButton moduleEighteen = InlineKeyboardButton.builder()
            .text("Исключение,отладка и логирование")
            .callbackData("Исключение,отладка и логирование")
            .build();
    public InlineKeyboardButton moduleNineteen = InlineKeyboardButton.builder()
            .text("Работа с файлами и сетью")
            .callbackData("работа с файлами и сетью")
            .build();
    public InlineKeyboardButton moduleTwenty = InlineKeyboardButton.builder()
            .text("Работа с MySQL в Java")
            .callbackData("работа с MySQL в Java")
            .build();
    public InlineKeyboardButton moduleTwentyone = InlineKeyboardButton.builder()
            .text("Протокол HTTP")
            .callbackData("протокол HTTP")
            .build();
    public InlineKeyboardButton moduleTwentytwo = InlineKeyboardButton.builder()
            .text("Разработка веб-приложения. ч.1")
            .callbackData("разработка веб-приложения. ч.1")
            .build();
    public InlineKeyboardButton moduleTwentythree = InlineKeyboardButton.builder()
            .text("Разработка веб-приложения. ч.2")
            .callbackData("разработка веб-приложения. ч.2")
            .build();

    public InlineKeyboardButton endWorkWithDB = InlineKeyboardButton.builder()
            .text("Завершить работу тг-бота!")
            .callbackData("end app")
            .build();

    private InlineKeyboardMarkup keyboardM1 = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(moduleOne))
            .keyboardRow(List.of(moduleTwo))
            .keyboardRow(List.of(moduleThree))
            .keyboardRow(List.of(moduleFour))
            .keyboardRow(List.of(moduleFive))
            .keyboardRow(List.of(moduleSix))
            .keyboardRow(List.of(moduleSeven))
            .keyboardRow(List.of(moduleEight))
            .keyboardRow(List.of(moduleNine))
            .keyboardRow(List.of(moduleTen))
            .keyboardRow(List.of(moduleEleven))
            .keyboardRow(List.of(moduleTwelve))
            .keyboardRow(List.of(moduleThirteen))
            .keyboardRow(List.of(moduleFourteen))
            .keyboardRow(List.of(moduleFifteen))
            .keyboardRow(List.of(moduleSixteen))
            .keyboardRow(List.of(moduleSeventeen))
            .keyboardRow(List.of(moduleEighteen))
            .keyboardRow(List.of(moduleNineteen))
            .keyboardRow(List.of(moduleTwenty))
            .keyboardRow(List.of(moduleTwentyone))
            .keyboardRow(List.of(moduleTwentytwo))
            .keyboardRow(List.of(moduleTwentythree))
            .keyboardRow(List.of(endWorkWithDB))
            .build();

    private InlineKeyboardMarkup sendModuleOne = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(whatArePrograms))
            .keyboardRow(List.of(webAppFrontAndBack))
            .keyboardRow(List.of(goalsAndAreaApplicationJava))
            .keyboardRow(List.of(howLooksProgrammingCode))
            .keyboardRow(List.of(downloadIntellijIdea))
            .keyboardRow(List.of(whiteSimpleApp))
            .keyboardRow(List.of(jarFile))
            .keyboardRow(List.of(featuresJava))
            .keyboardRow(List.of(practiceWorkModuleOne))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleTwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(variables))
            .keyboardRow(List.of(ifAndElseIf))
            .keyboardRow(List.of(booleanOperation))
            .keyboardRow(List.of(priorityAndStaplesInConditions))
            .keyboardRow(List.of(nestedConditions))
            .keyboardRow(List.of(threeOperator))
            .keyboardRow(List.of(commentsInCode))
            .keyboardRow(List.of(codeMakeApp))
            .keyboardRow(List.of(practiceWorkModuleTwo))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleThree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(cycleFor))
            .keyboardRow(List.of(cycleWhileAndDoWhile))
            .keyboardRow(List.of(switchCase))
            .keyboardRow(List.of(difficultCode))
            .keyboardRow(List.of(workLocalRepository))
            .keyboardRow(List.of(practiceWorkModuleThree))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleFour = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(methods))
            .keyboardRow(List.of(parametersMethods))
            .keyboardRow(List.of(returnsValues))
            .keyboardRow(List.of(classAndObjects))
            .keyboardRow(List.of(constructors))
            .keyboardRow(List.of(overloadMethods))
            .keyboardRow(List.of(areaVisibility))
            .keyboardRow(List.of(practiceWorkModuleFour))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleFive = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(encapsulation))
            .keyboardRow(List.of(pojo))
            .keyboardRow(List.of(immutable))
            .keyboardRow(List.of(linkOrValue))
            .keyboardRow(List.of(copyObjects))
            .keyboardRow(List.of(practiceWorkModuleFive))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSix = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(staticVariables))
            .keyboardRow(List.of(staticMethods))
            .keyboardRow(List.of(constants))
            .keyboardRow(List.of(Enum))
            .keyboardRow(List.of(staticInitialization))
            .keyboardRow(List.of(practiceWorkModuleSix))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleSeven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(primitivesAndObjects))
            .keyboardRow(List.of(typesOfPrimitives))
            .keyboardRow(List.of(bitsAndBytes))
            .keyboardRow(List.of(Numbers))
            .keyboardRow(List.of(symbols))
            .keyboardRow(List.of(wrapperClasses))
            .keyboardRow(List.of(practiceWorkModuleSeven))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleEight = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(operationsWithNumbers))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleNine = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleTen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleEleven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleTwelve = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleThirteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFourteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFifteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSixteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSeventeen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleEighteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleNineteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwenty = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwentyone = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwentytwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwentythree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(back))
            .build();



    @Override
    public String getBotUsername() {
        return "@study_java_sotnikov_bot";
    }

    @Override
    public String getBotToken() {
        return "7500467345:AAHp6mx2D300o_v3ksaure8-xkhNkfF7u-Q";
    }

    @Override
    public void onUpdateReceived(Update update) {
        buttonTab(update);
        isCommand(update.getMessage());
    }

    public void isCommand(Message message) {
        String text = message.getText();
        if (text.equals("/menu")) {
            sendMenu(message.getFrom().getId(), "<b>Модули</b>", keyboardM1);
        }
    }

    public void buttonTab(Update update) {
        if (update.hasCallbackQuery()) {
            String idUser = update.getCallbackQuery().getMessage().getChatId().toString();
            int idMessage = update.getCallbackQuery().getMessage().getMessageId();
            String data = update.getCallbackQuery().getData();
            String queryId = update.getCallbackQuery().getId();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(idUser)
                    .messageId(idMessage)
                    .text("")
                    .build();

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(idUser.toString())
                    .messageId(idMessage)
                    .build();

            if (data.equals("вводный модуль")) {
                editMessageText.setText("Вводный модуль");
                editMessageReplyMarkup.setReplyMarkup(sendModuleOne);
            } else if (data.equals("какие бывают программы")) {
                editMessageText.setText("Какие бывают программы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Какие бывают программы.pdf");
//                    materialForCourse.setName("Какие бывают программы");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Какие бывают программы");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Какие бывают программы(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Какие бывают программы(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("веб-приложения. Frontend и backend")) {
                editMessageText.setText("Веб-приложения. Frontend и backend");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Веб-приложения. Frontend и backend(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("цели и области применения Java")) {
                editMessageText.setText("Цели и области применения Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Цели и области применения Java.pdf");
//                    materialForCourse.setName("Цели и области применения Java");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Цели и области применения Java");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Цели и области применения Java(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Цели и области применения Java(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("как выглядит программный код")) {
                editMessageText.setText("Как выглядит программный код");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Как выглядит программный код.pdf");
//                    materialForCourse.setName("Как выглядит программный код");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Как выглядит программный код");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Как выглядит программный код(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Как выглядит программный код(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("пишем простое приложение")) {
                editMessageText.setText("Пишем простое приложение");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Пишем простое приложение.pdf");
//                    materialForCourse.setName("Пишем простое приложение");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Пишем простое приложение");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Пишем простое приложение(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Пишем простое приложение(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("особенности языка Java")) {
                editMessageText.setText("Особенности языка Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Особенности языка Java.pdf");
//                    materialForCourse.setName("Особенности языка Java");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Особенности языка Java");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Особенности языка Java(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Особенности языка Java(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Вводный модуль")) {
                editMessageText.setText("Практическая работа по Вводный модуль");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Практическая работа по Вводный модуль.pdf");
//                    materialForCourse.setName("Практическая работа по Вводный модуль");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Практическая работа по Вводный модуль");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Практическая работа по Вводный модуль(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Вводный модуль(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("синтаксис языка, часть 1")) {
                editMessageText.setText("Синтаксис языка, часть 1");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwo);
            } else if (data.equals("переменные")) {
                editMessageText.setText("Переменные");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Переменные.pdf");
//                    materialForCourse.setName("Переменные");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Переменные");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Переменные(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Переменные(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("условные операторы “if”и “else”")) {
                editMessageText.setText("Условные операторы “if”и “else”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Условные операторы “if”и “else”.pdf");
//                    materialForCourse.setName("Условные операторы “if”и “else”");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Условные операторы “if”и “else”");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Условные операторы “if”и “else”(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Условные операторы “if”и “else”(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("булевы операции")) {
                editMessageText.setText("Булевы операции");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Булевы операции.pdf");
//                    materialForCourse.setName("Булевы операции");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Булевы операции");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Булевы операции(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Булевы операции(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("приоритеты и скобки в условиях")) {
                editMessageText.setText("Приоритеты и скобки в условиях");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                  Ниже закоментированный код, нужно раскомментировать для сохранения в БД
//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Приоритеты и скобки в условиях.pdf");
//                    materialForCourse.setName("Приоритеты и скобки в условиях");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Приоритеты и скобки в условиях");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Приоритеты и скобки в условиях(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Приоритеты и скобки в условиях(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("вложенные условия")) {
                editMessageText.setText("Вложенные условия");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Вложенные условия.pdf");
//                    materialForCourse.setName("Вложенные условия");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Вложенные условия");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Вложенные условия(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Вложенные условия(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("тернарный оператор")) {
                editMessageText.setText("Тернарный оператор");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Тернарный оператор.pdf");
//                    materialForCourse.setName("Тернарный оператор");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Тернарный оператор");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Тернарный оператор(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Тернарный оператор(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("комментарии в коде")) {
                editMessageText.setText("Комментарии в коде");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Комментарии в коде.pdf");
//                    materialForCourse.setName("Комментарии в коде");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Комментарии в коде");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Комментарии в коде(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Комментарии в коде(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("разбираем код готового приложения")) {
                editMessageText.setText("Разбираем код готового приложения");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Road-camera(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по с я часть 1")) {
                editMessageText.setText("Практическая работа по Синтаксис языка, часть 1");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Практическая работа по Синтаксис языка часть 1.pdf");
//                    materialForCourse.setName("Практическая работа по Синтаксис языка часть 1");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Практическая работа по Синтаксис языка часть 1");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Практическая работа по Синтаксис языка часть 1(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Синтаксис языка часть 1(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("синтаксис языка, часть 2")) {
                editMessageText.setText("Синтаксис языка, часть 2");
                editMessageReplyMarkup.setReplyMarkup(sendModuleThree);
            } else if (data.equals("цикл “for”")) {
                editMessageText.setText("Цикл “for”");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Цикл “for”(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("циклы “while” и “do while”")) {
                editMessageText.setText("Циклы “while” и “do while”");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Циклы “while” и “do while”(get DB).pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("оператор “switch … case”")) {
                editMessageText.setText("Оператор “switch … case”");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Оператор “switch … case”(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Оператор “switch … case”.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("разбираем сложный код")) {
                editMessageText.setText("Разбираем сложный код");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Разбираем сложный код(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Разбираем сложный код.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("работа с локальным репозиторием")) {
                editMessageText.setText("Работа с локальным репозиторием");
//hello
                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Работа с локальным репозиторием(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Работа с локальным репозиторием.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по с я часть 2")) {
                editMessageText.setText("Практическая работа по Синтаксис языка, часть 2");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Синтаксис языка, часть 2(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Синтаксис языка, часть 2.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("методы и классы")) {
                editMessageText.setText("Методы и классы");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFour);
            } else if (data.equals("методы")) {
                editMessageText.setText("Методы");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Методы(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Методы.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("параметры методов")) {
                editMessageText.setText("Параметры методов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Параметры методов.pdf");
//                    materialForCourse.setName(Параметры методов");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Параметры методов");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Параметры методов(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Параметры методов(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Параметры методов.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("возвращаемые значения")) {
                editMessageText.setText("Возвращаемые значения");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("data/Возвращаемые значения.pdf");
//                    materialForCourse.setName(Возвращаемые значения");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Возвращаемые значения");
//                    FileOutputStream fileOutputStream = new FileOutputStream("data/Возвращаемые значения(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Возвращаемые значения(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Возвращаемые значения.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("классы и объекты")) {
                editMessageText.setText("Классы и объекты");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Классы и объекты(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Классы и объекты.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("конструкторы")) {
                editMessageText.setText("Конструкторы");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Конструкторы(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Конструкторы.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("перегрузка методов")) {
                editMessageText.setText("Перегрузка методов");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Перегрузка методов(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Перегрузка методов.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("области видимости")) {
                editMessageText.setText("Области видимости");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Области видимости(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Области видимости.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Методы и классы")) {
                editMessageText.setText("Практическая работа по Методы и классы");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Методы и классы(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Методы и классы.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("инкапсуляция")) {
                editMessageText.setText("Инкапсуляция");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFive);

            } else if (data.equals("POJO-классы, гет и сет")) {
                editMessageText.setText("POJO-классы, геттеры и сеттеры");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/POJO-классы, геттеры и сеттеры(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/POJO-классы, геттеры и сеттеры.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("immutable-классы")) {
                editMessageText.setText("Immutable-классы");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Передача по ссылке или по значению(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Immutable-классы.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("ссылка или значение")) {
                editMessageText.setText("Ссылка или значение");

                try {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Передача по ссылке или по значению(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Передача по ссылке или по значению.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("копирование объектов")) {
                editMessageText.setText("Копирование объектов");

                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Копирование объектов(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Копирование объектов.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Инкапсуляция")) {
                editMessageText.setText("Практическая работа по Инкапсуляция");

                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Инкапсуляция(get DB).pdf")));
                    sendDocument.setDocument(new InputFile(new File("data/Практическая работа по Инкапсуляция.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("static, константы и enum")) {
                editMessageText.setText("Static, константы и enum");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSix);
            } else if (data.equals("cтатические переменные")) {
                editMessageText.setText("Cтатические переменные");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Статические переменные.pdf")));
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("cтатические методы")) {
                editMessageText.setText("Cтатические методы");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Статические методы.pdf")));
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("константы")) {
                editMessageText.setText("Константы");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Константы.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("enum")) {
                editMessageText.setText("Enum");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Enum.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("cтатическая инициализация")) {
                editMessageText.setText("Статическая инициализация");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Статическая инициализация.pdf")));

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по static, константы и enum")) {
                editMessageText.setText("Практическая работа по по static, константы и enum ");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Статическая инициализация.pdf")));

                    execute(sendDocument);
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("примитивы")) {
                editMessageText.setText("Примитивы");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSeven);

            }    else if (data.equals("примитивы и обекты")) {
                    editMessageText.setText("Примитивы и обекты");
                    try {
                        SendDocument sendDocument = new SendDocument();
                        sendDocument.setChatId(idUser);
                        sendDocument.setDocument(new InputFile(new File("data/Примитивы и объекты.pdf")));
                        execute(sendDocument);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
            }    else if (data.equals("виды примитивов")) {
                editMessageText.setText("Виды примитивов");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Виды примитивов.pdf")));
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }    else if (data.equals("биты и байты")) {
                editMessageText.setText("Биты и байты");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Биты и байты.pdf")));
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }    else if (data.equals("числа")) {
                editMessageText.setText("Числа");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Конспект.Числа.pdf")));
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }    else if (data.equals("символы")) {
                editMessageText.setText("Символы");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Символы.pdf")));
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }    else if (data.equals("классы-обертки")) {
                editMessageText.setText("Классы-обертки");
                try {
                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(idUser);
                    sendDocument.setDocument(new InputFile(new File("data/Классы-обертки.pdf")));
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по static, примитивы")) {
                    editMessageText.setText("Практическая работа по примитивы ");
                    try {
                        SendDocument sendDocument = new SendDocument();
                        sendDocument.setChatId(idUser);
                        sendDocument.setDocument(new InputFile(new File("data/Практическая работа примитивы.pdf")));

                        execute(sendDocument);
                    }
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

            } else if (data.equals("числа и даты")) {
                editMessageText.setText("Числа и даты");
                editMessageReplyMarkup.setReplyMarkup(sendModuleEight);
            }    else if (data.equals("оперпации с числами")) {
            editMessageText.setText("Оперпации с числами");
            try {
                SendDocument sendDocument = new SendDocument();
                sendDocument.setChatId(idUser);
                sendDocument.setDocument(new InputFile(new File("data/Операции с числами..pdf")));
                execute(sendDocument);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

  //
            }  else if (data.equals("end app")) {
                editMessageText.setText("Saved data in DataBase and the application is completed!");

                try {
                    //Для закрытия сессии при работе с БД
//                    transaction.commit();
//                    sessionFactory.close();

//                    //Open session and other
//                    standardServiceRegistry = new StandardServiceRegistryBuilder()
//                            .configure("hibernate.cfg.xml").build();
//                    metadata = new MetadataSources(standardServiceRegistry)
//                            .getMetadataBuilder()
//                            .build();
//                    sessionFactory = metadata.getSessionFactoryBuilder()
//                            .build();
//                    session = sessionFactory.openSession();
//                    transaction = (Transaction) session.beginTransaction();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("назад")) {
                editMessageText.setText("Модули");
                editMessageReplyMarkup.setReplyMarkup(keyboardM1);
            }

            AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                    .callbackQueryId(queryId)
                    .build();

            try {
                execute(answerCallbackQuery);
                execute(editMessageText);
                execute(editMessageReplyMarkup);
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

    public void sendMenu(Long who, String txt, InlineKeyboardMarkup km) {
        System.out.println(txt + "\n" + who + "\n" + km);
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .parseMode("HTML")
                .text(txt)
                .replyMarkup(km)
                .build();

        try {
            execute(sm);
        } catch (TelegramApiException tae) {
            throw new RuntimeException(tae);
        }
    }
}
