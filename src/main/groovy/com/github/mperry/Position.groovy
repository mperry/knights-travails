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

	final static int MAX = 8
	final static int LOWERCASE_OFFSET = 96
	final static int UPPERCASE_OFFSET = 64

	Integer row
	Integer column

	Position(Integer r, Integer c) {
		row = r
		column = c
	}

	String toString() {
		"${toString(column)}$row"
	}

	Position(int r, String col) {
		column = toInt(col)
		row = r
	}

	static Option<Position> create(Integer c, Integer r) {
		def p = new Position(r, c)
		(r > MAX || c > MAX || r <= 0 || c <= 0) ? Option.none() : Option.some(p)
	}

	static String toString(int i) {
		def c = (char) (UPPERCASE_OFFSET + i)
		c.toString()
	}

	static int toInt(String s) {
		(((int)s.charAt(0)) - UPPERCASE_OFFSET)
	}




}
