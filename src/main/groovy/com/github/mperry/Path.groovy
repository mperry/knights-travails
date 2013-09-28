package com.github.mperry

import groovy.transform.Canonical
import groovy.transform.TypeChecked

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 28/09/13
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Canonical
@TypeChecked
class Path {

	Position current
	List<Position> previous

}
