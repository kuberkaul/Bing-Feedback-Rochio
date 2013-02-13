//package bingsearchpp;

import java.util.List;

public class Doc {
	
	private String text;
	private int id;
	private static int count = 0;
	private int totalTerms = 0;
	private List<Term> termList;
	private double[] vector;
	private boolean isRelevant = false;
	private int docLength;
	
	public Doc(String text, boolean isRelevant) {
		this.text = text;
		setTotalTerms();
		id = count ++;
		this.isRelevant = isRelevant;
		docLength = text.split(" ").length;
	}
	
	public static void resetCount() {
		Doc.count = 0;
	}
	
	public void setOccurencesOfTerms(Term term)
	{
		if(termList.contains(term))
		{
			term.incrementOccurences(this.getId());
		}
	}
	
	public int getDocLength() {
		return docLength;
	}
	
	public boolean isRelevant() {
		return isRelevant;
	}
	
	public void makeVector()
	{	
		vector = new double[termList.size()];
		for(int i = 0; i < termList.size(); i ++)
		{
			vector[i] = ((double)termList.get(i).getTfidf(this));
		}
	}
	
	private void setTotalTerms()
	{
		String[] t1 = text.split(" ");
		for (int i = 0; i < t1.length; i ++)
		{
			totalTerms ++;
		}
	}
	
	public List<Term> getTermList() {
		return termList;
	}
	
	public void setTermList(List<Term> list)
	{
		termList = list;
	}
	
	public int getTotalTerms() {
		return totalTerms;
	}
	
	public String getText() {
		return text;
	}
	
	public int getId() {
		return id;
	}

	public double[] getVector() {
		return vector;
	}

	public List<Term> getSortedList()
	{
		for (int i = 1; i < termList.size(); i++)
		{
			int j = i;
			Term B = termList.get(i);
			while ((j > 0) && (termList.get(j-1).getTfidf(this) < B.getTfidf(this)))
			{
				termList.set(j, termList.get(j-1));
				j--;
			}
			termList.set(j, B);
		}
		/*for(int i = 0; i < termList.size(); i ++)
		{
			System.err.println(termList.get(i).getTerm()+" "+termList.get(i).getTfidf(this));
		}*/
		return termList;
	}
	
}