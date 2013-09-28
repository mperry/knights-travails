package com.github.mperry

import fj.data.Option
import groovy.transform.TypeChecked

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 28/09/13
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
@TypeChecked
class KnightMover {

	static List<Option<Position>> next(Position p) {
		[ne(p), nw(p), en(p), es(p), se(p), sw(p), ws(p), wn(p)]
	}

	static List<Option<Position>> nextMoves(Position p) {
		def list = next(p)
		list.filter { Option<Position> op -> op.isSome() } as List<Option<Position>>
	}

	static List<Position> validNextMoves(Position p) {
		def list = nextMoves(p)
		list.collect { Option<Position> op -> op.some() }

	}

	static Option<Position> ne(Position p) {
		Position.create(p.column + 1, p.row + 2)
	}

	static Option<Position> nw(Position p) {
		Position.create(p.column - 1, p.row + 2)
	}

	static Option<Position> en(Position p) {
		Position.create(p.column + 2, p.row + 1)
	}

	static Option<Position> es(Position p) {
		Position.create(p.column + 2, p.row - 1)
	}

	static Option<Position> se(Position p) {
		Position.create(p.column + 1, p.row - 2)
	}

	static Option<Position> sw(Position p) {
		Position.create(p.column - 1, p.row - 2)
	}

	static Option<Position> ws(Position p) {
		Position.create(p.column - 2, p.row - 1)
	}

	static Option<Position> wn(Position p) {
		Position.create(p.column - 2, p.row + 1)
	}
}
