package myPack

annotation class Anno(val number: Int)

fun topLevelFun() {
    class LocalClass {
        fun @receiver:Anno(<!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>42.function()<!>) Int.function() = 1
    }
}
