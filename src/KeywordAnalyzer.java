abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();  // "только для наследников." возвращать набор ключевых слов
    protected abstract Label getLabel();       // метка, которой необходимо пометить положительные срабатывания.

    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}