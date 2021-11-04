package com.hong.base

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun myTest(){
        test()
    }
    fun test(){
        val student = Student("张三",12)
        val data = SimpleData<Student>(student)
        handleSimpleData(data)
        val studentData = data.get()
    }
    private fun handleSimpleData(data:SimpleData<Person>){
        val personDat = data.get()
        println("name:${personDat!!.name}")
    }
}