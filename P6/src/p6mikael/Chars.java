package p6mikael;


public class Chars {
	
	/**
	 * A class that defines the signs that are connected to the
	 * Array7x7 - object
	 *      
	 * @author Martin Gyllstr�m
	 */
	
	/**
	 * Uppercase letters
	 */
	
	private Array7x7[] characters = new Array7x7[128];
	
	public Chars()
	{
		for (int index=0;index<characters.length;index++)
		{
//			characters[index] = new Array7x7(UNKNOWN); //S�tter alla tecken till "unknown" vid initering
		}
	
		
		characters['A'] = new Array7x7(charA);
		characters['B'] = new Array7x7(charB);
		characters['C'] = new Array7x7(charC);
		characters['D'] = new Array7x7(charD);
		characters['E'] = new Array7x7(charE);
		characters['F'] = new Array7x7(charF);
		characters['G'] = new Array7x7(charG);
		characters['H'] = new Array7x7(charH);
		characters['I'] = new Array7x7(charI);
		characters['J'] = new Array7x7(charJ);
		characters['K'] = new Array7x7(charK);
		characters['L'] = new Array7x7(charL);
		characters['M'] = new Array7x7(charM);
		characters['N'] = new Array7x7(charN);
		characters['O'] = new Array7x7(charO);
		characters['P'] = new Array7x7(charP);
		characters['Q'] = new Array7x7(charQ);
		characters['R'] = new Array7x7(charR);
		characters['S'] = new Array7x7(charS);
		characters['T'] = new Array7x7(charT);
		characters['U'] = new Array7x7(charU);
		characters['V'] = new Array7x7(charV);
		characters['X'] = new Array7x7(charX);
		characters['Y'] = new Array7x7(charY);
		characters['Z'] = new Array7x7(charZ);
		
		//Endast versaler A-Z
	}
	
	public Array7x7 getChar(char chr)
	{
		if (chr>=0 && chr <=127)
		{
			return characters[chr];
		}
		return null;
	}
	
	private static int[][] charA = {
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,0,1,0,1,0,0},
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0}};
	
	private static int[][] charB = {
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0}};
	
	private static int[][] charC = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
			
	private static int[][] charD = {
			{0,1,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,1,0,0},
			{0,1,1,1,0,0,0}};
	
	private static int[][] charE = {
			{0,1,1,1,1,1,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,1,0}};
	
	private static int[][] charF = {
			{0,1,1,1,1,1,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0}};
	
	private static int[][] charG = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,1,1,1,0},
			{0,0,1,0,0,1,0},
			{0,0,0,1,1,0,0}};
	
	private static int[][] charH = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0}};
	
	private static int[][] charI = {
			{0,0,1,1,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] charJ = {
			{0,1,1,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] charK = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,1,0,0},
			{0,1,0,1,0,0,0},
			{0,1,1,0,0,0,0},
			{0,1,0,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,0,1,0}};
	
	private static int[][] charL = {
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,1,0}};
	
	private static int[][] charM = {
			{0,1,1,0,1,1,0},
			{0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0}};
	
	private static int[][] charN = {
			{0,1,0,0,0,1,0},
			{0,1,1,0,0,1,0},
			{0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0},
			{0,1,0,0,1,1,0},
			{0,1,0,0,0,1,0}};
	
	private static int[][] charO = {
			{0,0,1,1,1,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] charP = {
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0}};
	
	private static int[][] charQ = {
			{0,0,1,1,1,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,1,0},
			{0,0,1,1,1,0,1}};
	
	private static int[][] charR = {
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0}};
	
	private static int[][] charS = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,0,0},
			{0,0,1,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,1,1,1,1,0,0}};
	
	private static int[][] charT = {
			{0,1,1,1,1,1,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0}};
	
	private static int[][] charU = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] charV = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0}};
	
	private static int[][] charW = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0},
			{0,0,1,1,1,0,0},
			{0,0,1,0,1,0,0},
			{0,0,1,0,1,0,0}};
	
	private static int[][] charX = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0}};
	
	private static int[][] charY = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0}};
	
	private static int[][] charZ = {
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,1,0}};
	
	/**
	 * Numbers 0-9 
	 */
	
	private static int[][] char0 = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,1,1,0},
			{0,1,0,1,0,1,0},
			{0,1,1,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] char1 = {
			{0,0,1,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] char2 = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,1,1,1,1,0}};
	
	private static int[][] char3 = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] char4 = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0}};
	
	private static int[][] char5 = {
			{0,1,1,1,1,1,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,1,1,1,1,0,0}};
	
	private static int[][] char6 = {
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0}};
	
	private static int[][] char7 = {
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0}};
	
	private static int[][] char8 = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,1,0,1,1,0},
			{0,0,1,1,1,0,0}};
	
	private static int[][] char9 = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0}};
	
	/**
	 * Diffrent signs that may be used
	 */
	
	private static int[][] SPACE = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] DOT = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0}};
			
	private static int[][] UNKNOWN = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
			
	private static int[][] ADD = {
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,1,1,1,1,1,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] SUB = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};

	private static int[][] MULTIPLY = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};

	private static int[][] DIVIDE = {
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] EQUALS = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] QUESTIONMARK = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,1,0},
			{0,0,0,1,1,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0}};
	
	private static int[][] EXCLAMATION = {
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0}};
	
	private static int[][] SLASH = {
			{0,0,0,0,0,0,1},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{1,0,0,0,0,0,0}};
	
	private static int[][] PERCENT = {
			{0,0,0,0,0,0,1},
			{0,1,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,1,0},
			{1,0,0,0,0,0,0}};
	
	private static int[][] PARENTHESIS1 = {
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,0,1,0,0,0}};
	
	private static int[][] PARANTHESIS2 = {
			{0,0,0,1,0,0,0},
			{0,0,0,0,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0}};
	
	private static int[][] GREATER = {
			{0,1,1,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,1,1,0,0,0,0}};
	
	private static int[][] SMALLER = {
			{0,0,0,0,1,1,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,1,1,0}};
	
	private static int[][] att = {  // Snabel-a sv�rt!!! ;)
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
	
	/**
	 * Lowercase letters
	 */
	
	private static int[][] chara = {  
			{0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,1,1,0},
			{0,0,1,1,0,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charb = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charc = {  
			{0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,0,1,1,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] chard = {  
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,1,1,1,1,0},
			{0,1,1,0,0,1,0},
			{0,0,1,1,1,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] chare = {  
			{0,0,0,0,0,0,0},
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,0,1,1,1,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charf = {  
			{0,0,0,0,0,0,0},
			{0,0,0,1,1,0,0},
			{0,0,1,0,0,0,0},
			{0,1,1,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charg = {  
			{0,0,0,0,0,0,0},
			{0,0,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,0,1,1,1,0,0},
			{0,0,0,0,1,0,0},
			{0,1,1,1,1,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charh = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] chari = {  
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charj = {  
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] chark = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,1,0,0,0},
			{0,1,1,0,0,0,0},
			{0,1,0,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charl = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charm = {  
			{0,0,0,0,0,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,1,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charn = {  
			{0,0,0,0,0,0,0},
			{0,1,0,1,1,0,0},
			{0,1,1,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charo = {  
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charp = {  
			{0,0,0,0,0,0,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charq = {  
			{0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charr = {  
			{0,0,0,0,0,0,0},
			{0,1,0,1,1,0,0},
			{0,1,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] chars = {  
			{0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0},
			{0,1,0,0,0,0,0},
			{0,0,1,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] chart = {  
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,1,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,1,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charu = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charv = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charw = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charx = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] chary = {  
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,1,0,0,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charz = {  
			{0,0,0,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0}};
	
	private static int[][] charsomthing = {  // Fors�tt g�rna med n�got
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
	
	
	
}