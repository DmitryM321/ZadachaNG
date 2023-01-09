class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private final String[] keywords; // конструироваться от массива строк с ключевыми словами

    public SpamAnalyzer(String[] keywords) {  // проверяют текст на наличие каких-либо ключевых слов, получаем их из конструктора
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {   // возвращает поле keywords
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM; //  вернуть именно label этого фильтра
    }
}