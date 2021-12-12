package org.sse.examples

import java.util.stream.Stream

fun main() {
    val sep = "\r\n---------------------------------------------------------"

    val r = 1..10
    r.filter { v -> v != 5 }
        .forEach { v -> print("${v} ") }

    println(sep)

    val fib = Stream.iterate(arrayOf(0, 1), { v -> arrayOf(v[1], v[0] + v[1]) })
    fib.skip(0)
        .limit(20)
        .forEach { v -> print("${v[0]} ") }

    println(sep)

    generateSequence(0) { it + 2 }
        .take(10)
        .forEach { print("${it} ") }
}