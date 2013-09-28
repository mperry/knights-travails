package com.github.mperry

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 28/09/13
 * Time: 12:50 AM
 * To change this template use File | Settings | File Templates.
 */
class Test1 {

	static void main(def args) {
		def s = Position.toString(1)
		def a = Position.toInt("A")

		def p1 = PositionReader.read("A1")
		println("$p1")
	}

}
