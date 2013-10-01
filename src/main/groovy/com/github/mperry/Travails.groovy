package com.github.mperry

import fj.P
import fj.P2
import fj.data.Option
import groovy.transform.TypeChecked

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 28/09/13
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
@TypeChecked
class Travails {

	static void main(def args) {
		new Travails().go()
	}

	P2<String, String> ends() {
		P.p("A8", "B7")
	}

	void go() {
		def p = ends()
		def oList = go(p._1(), p._2())
		println("start: ${p._1()} end: ${p._2()} path: $oList")
	}

	Option<List<Position>> go(String p1, String p2) {
		def start = PositionReader.read(p1)
		def end = PositionReader.read(p2)
		go(start, end)
	}

	Option<List<Position>> go(Option<Position> start, Option<Position> end) {
		def oList = start.bind { Position startP ->
			end.map { Position endP ->
				def p2 = go(new Path(startP, []), endP)
				def p3 = p2.previous.tail() + p2.current
				p3
			}
		}
		oList
	}

	Path go(Path p, Position end) {
		breadthFirst([p], end)
	}

	Path breadthFirst(List<Path> paths, Position end) {
		def done = paths.filter { Path p -> p.current == end } as List<Path>
		if (done.size() > 0) {
			done.head()
		} else {
			def p2 = paths.collect { Path p ->
				KnightMover.validNextMoves(p.current).collect { Position p2 ->
					new Path(p2, p.previous + p.current as List<Position>)
				}
			}.flatten() as List<Path>
			breadthFirst(p2, end)
		}
	}

}
