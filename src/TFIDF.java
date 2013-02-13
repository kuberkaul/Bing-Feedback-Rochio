//package bingsearchpp;


class TFIDF implements Comparable<TFIDF>{
        private Number numOfOccurrences;
        private Number totalTermsInDocument;
        private Number totalDocuments;
        private Number numOfDocumentsWithTerm;
        
        public TFIDF(Number occ, Number totTerms, Number totDocs, Number docsWithTerms) {
                numOfOccurrences = occ;
                totalTermsInDocument = totTerms;
                totalDocuments = totDocs;
                numOfDocumentsWithTerm = docsWithTerms;
        }
        
        public Double getValue(){
                double tf = Math.sqrt((numOfOccurrences.floatValue() / (Float.MIN_VALUE + (totalTermsInDocument.floatValue())+15)));
                float idf = (float) Math.log10(totalDocuments.floatValue() / (Float.MIN_VALUE + numOfDocumentsWithTerm.floatValue()));
                return (tf * idf);
        }
        
        public int getNumOfOccurrences() {
                return this.numOfOccurrences.intValue();
        }
        
        public String toString() {
                return this.getValue().toString();
        }
        
        @Override
        public int compareTo(TFIDF o) {
                return (int) ((this.getValue() - o.getValue()) * 100);
        }
}