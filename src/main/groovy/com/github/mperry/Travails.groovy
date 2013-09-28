package com.github.mperry

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



	void go() {
		def start = PositionReader.read("A8")
		def end = PositionReader.read("B7")
		def path1 = new Path(start, [])
		def p2 = go(path1, end)
		def p3 = p2.previous.tail() + p2.current
		println("start: $start end: $end path: $p3")
		int z = 0
	}

	Path go(Path p, Position end) {
		breadthFirst([p], end)
	}

	Path breadthFirst(List<Path> paths, Position end) {
		def done = paths.filter {Path p -> p.current == end } as List<Path>
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
