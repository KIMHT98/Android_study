package com.example.ch_08_inheritanceapp

class OffSpring:Secondary(), Archer,Singer {
    override fun archery() {
//        super.archery()
        println("Archery skills enhanced by OffSpring")
    }

    override fun sing() {
//        super.sing()
        println("Singing skill enhanced by OffSpring")
    }

    override fun role() {
        super.role()
    }
}