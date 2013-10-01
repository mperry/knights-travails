package com.github.mperry

import fj.data.Option
import groovy.transform.Canonical
import groovy.transform.TypeChecked

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 28/09/13
 * Time: 12:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Canonical
@TypeChecked
class Position {

	final static int MIN = 1
	final static int MAX = 8
//	final static int LOWERCASE_OFFSET = 96
//	final static int UPPERCASE_OFFSET = 64
	final static int CAPITAL_A = (int)('A'.charAt(0)) // 65
	final static int OFFSET = CAPITAL_A - 1

	Integer row
	Integer column

	Position(Integer r, Integer c) {
		row = r
		column = c
	}

	String toString() {
		"${toString(column)}$row"
	}

	static Option<Position> create(Integer r, String s) {
		s.length() != 1 ? Option.none() : Position.create(r, toInt(s))
	}

	static Option<Position> create(Integer r, Integer c) {
		def p = new Position(r, c)
		(r > MAX || c > MAX || r < MIN || c < MIN) ? Option.none() : Option.some(p)
	}

	static String toString(int i) {
		def c = (char) (OFFSET + i)
		c.toString()
	}

	static int toInt(String s) {
		toInt(s.charAt(0))
	}

	static int toInt(char c) {
		((int)c) - OFFSET
	}

}
