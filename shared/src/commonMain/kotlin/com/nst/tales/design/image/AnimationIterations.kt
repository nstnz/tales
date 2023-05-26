package com.nst.tales.design.image

sealed interface AnimationIterations {

	data class FixedCount(val times: Int) : AnimationIterations

	object Forever : AnimationIterations
}