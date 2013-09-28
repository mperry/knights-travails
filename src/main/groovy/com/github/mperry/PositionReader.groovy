package com.github.mperry

import groovy.transform.TypeChecked

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 28/09/13
 * Time: 12:52 AM
 * To change this template use File | Settings | File Templates.
 */
@TypeChecked
class PositionReader {

	static final int COLUMN_INDEX = 0
	static final int ROW_INDEX = 1

	static Position read(String s) {
		def col = stringAt(s, COLUMN_INDEX)
		def row = stringAt(s, ROW_INDEX).toInteger()
		new Position(row, col)
	}

	static String stringAt(String s, int i) {
		s.charAt(i).toString()
	}

}
