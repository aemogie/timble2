package io.github.aemogie.timble.util;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class TimbleMath {
	public static float map(float value, float originStart, float originEnd, float targetStart, float targetEnd) {
		float mappedVal;
		mappedVal = (value - originStart); //Get value starting from 0
		mappedVal /= (originEnd - originStart); //Divide that ny the total range to get a value between 1 and 0.
		mappedVal *= (targetEnd - targetStart); //Multiply by required range to get a value between those 2 numbers.
		mappedVal += targetStart; //Add the start of required range so that it is back in the range it was supposed to be.
		return mappedVal;
	}
}
