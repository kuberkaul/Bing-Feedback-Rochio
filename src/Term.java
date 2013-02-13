//package bingsearchpp;

class Term
{
	private String term;
	private double weight;
	private int[] occurences = new int[10];
	private int docsWithTerm = 0;
	private boolean[] presentInDoc = new boolean[10];
	private double[] tfidf = new double[10];
	//private TFIDF[] tfidf = new TFIDF[10];
	
	Term(String s)
	{
		term = s;
		for ( int i = 0; i < 10; i ++)
		{
			occurences[i] = 0;
			presentInDoc[i] = false;
		}
	}
	
	public void setPresentInDoc(int docId) {
		presentInDoc[docId] = true;
	}
	
	public void setTfidf(Doc doc, double averageTermsInDoc)
	{
		tfidf[doc.getId()] = new TFIDF(occurences[doc.getId()], averageTermsInDoc, 10, docsWithTerm).getValue();
		//double tf = (double)occurences[doc.getId()] / (doc.getTotalTerms() + Double.MIN_VALUE);
		//double idf = Math.log10(10 / (docsWithTerm + Double.MIN_VALUE));
		//tfidf[doc.getId()] = tf * idf;
	}
	
	public double getTfidf(Doc doc) {
		return tfidf[doc.getId()];
	}
	
	public String getTerm() {
		return term;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int getOccurences(int docId) {
		return occurences[docId];
	}
	
	public void setDocWithTerm(int docWithTerm) {
		this.docsWithTerm = docWithTerm;
	}
	
	public void incrementOccurences(int docId)
	{	
		//System.err.println(docId + "%%%%%%%%%%%%%%%%%%%%%%%");
		occurences[docId] ++;
	}
	
	public void setTermFreq(double[] termFreq) {
		for (int i = 0; i < 10; i ++)
		{
		//	termFreq[i] = occurences[i] / findMax();
		}
	}
	
	public void incrementDocsWithTerm()
	{
		docsWithTerm ++;
	}
	
	/*public double getOccurences(int docId) {
		return ((double)occurences[docId]/findMax());
	}*/
	
	public int getDocsWithTerm() {
		return docsWithTerm;
	}
	
	public int findMaxInDoc(int docId)
	{
		int max = 0;
		for (int i = 0; i < 10; i ++)
		{
			if(occurences[i]>max)
				max = occurences[i];
		}
		return max;
	}
	
	public boolean[] getPresentInDoc() {
		return presentInDoc;
	}
}