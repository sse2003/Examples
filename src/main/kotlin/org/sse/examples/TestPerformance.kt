package org.sse.examples

fun main() {
    val tp = TestPerformance()
    tp.f1(null)

}

class TestPerformance
{
    fun f1(args: Array<String>?)
    {
        println("123")
    }
}