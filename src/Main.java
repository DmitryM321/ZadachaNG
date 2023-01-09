public class Main {   // checkLabels - подставляет массив анализаторов, которые в свою очередь проверяют текст text на наличие чего-то неудобного. Классы же которые требовалось написать - KeywordAnalyzer, SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer так или иначе реализуют этот интерфейс TextAnalyzer.
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {  // возвращать метку для комментария по набору анализаторов текста
        for (TextAnalyzer analyzer: analyzers)   // analyzers, вызываем для текущего analyzer метод processText и, если метка не ОК, то выходим и возвращаем не ОК метку.
        { if (analyzer.processText(text)!=Label.OK){ // возвращать первую не-OK метку в порядке данного набора анализаторов
            return analyzer.processText(text);
        }
        }
        return Label.OK; //OK, если все анализаторы вернули OK.
    }
    public static void main(String[] args) {
        TooLongTextAnalyzer longNext = new TooLongTextAnalyzer(8);
        NegativeTextAnalyzer negativeText = new NegativeTextAnalyzer();
        SpamAnalyzer spamText = new SpamAnalyzer(new String[]{"Нельзя", "Фу", "Все еще нельзя"}); // Спам-слова
        System.out.println(checkLabels(new TextAnalyzer[]{longNext, negativeText, spamText}, "Короткое"));
        System.out.println(checkLabels(new TextAnalyzer[]{longNext, negativeText, spamText}, "Слишком длинное сообщение"));
        System.out.println(checkLabels(new TextAnalyzer[]{negativeText, longNext, spamText}, ":)"));
        System.out.println(checkLabels(new TextAnalyzer[]{negativeText, longNext, spamText}, ":("));
        System.out.println(checkLabels(new TextAnalyzer[]{spamText, longNext, negativeText}, "Можно"));
        System.out.println(checkLabels(new TextAnalyzer[]{spamText, longNext, negativeText}, "Все еще нельзя"));
    }
}




//    public static void main(String[] args) {
//        // инициализация анализаторов для проверки в порядке данного набора анализаторов
//        String[] spamKeywords = {"spam", "bad"};
//        int commentMaxLength = 40;
//        TextAnalyzer[] textAnalyzers1 = {
//                new SpamAnalyzer(spamKeywords),
//                new NegativeTextAnalyzer(),
//                new TooLongTextAnalyzer(commentMaxLength)
//        };
//        TextAnalyzer[] textAnalyzers2 = {
//                new SpamAnalyzer(spamKeywords),
//                new TooLongTextAnalyzer(commentMaxLength),
//                new NegativeTextAnalyzer()
//        };
//        TextAnalyzer[] textAnalyzers3 = {
//                new TooLongTextAnalyzer(commentMaxLength),
//                new SpamAnalyzer(spamKeywords),
//                new NegativeTextAnalyzer()
//        };
//        TextAnalyzer[] textAnalyzers4 = {
//                new TooLongTextAnalyzer(commentMaxLength),
//                new NegativeTextAnalyzer(),
//                new SpamAnalyzer(spamKeywords)
//        };
//        TextAnalyzer[] textAnalyzers5 = {
//                new NegativeTextAnalyzer(),
//                new SpamAnalyzer(spamKeywords),
//                new TooLongTextAnalyzer(commentMaxLength)
//        };
//        TextAnalyzer[] textAnalyzers6 = {
//                new NegativeTextAnalyzer(),
//                new TooLongTextAnalyzer(commentMaxLength),
//                new SpamAnalyzer(spamKeywords)
//        };
//        // тестовые комментарии
//        String[] tests = new String[8];
//        tests[0] = "This comment is so good.";                            // OK
//        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
//        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
//        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
//        tests[4] = "This comment is so bad....";                          // SPAM
//        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
//        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
//        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
//        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
//                textAnalyzers4, textAnalyzers5, textAnalyzers6};
//        Main testObject = new Main();
//        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
//        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
//        for (String test : tests) {
//            numberOfAnalyzer = 1;
//            System.out.print("test #" + numberOfTest + ": ");
//            System.out.println(test);
//            for (TextAnalyzer[] analyzers : textAnalyzers) {
//                System.out.print(numberOfAnalyzer + ": ");
//                System.out.println(testObject.checkLabels(analyzers, test));
//                numberOfAnalyzer++;
//            }
//            numberOfTest++;
//        }
//    }
//}
