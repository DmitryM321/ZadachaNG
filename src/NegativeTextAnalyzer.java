public class NegativeTextAnalyzer extends KeywordAnalyzer  {

        private final String[] KEYWORDS = {":(", "=(", ":|"}; //  сразу же инициализируется указанными в задании смайлами,

        @Override
        protected String[] getKeywords() {
            return KEYWORDS;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;  //  вернуть именно label этого фильтра
        }

    }
