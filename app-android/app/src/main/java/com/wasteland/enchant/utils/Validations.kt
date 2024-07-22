package com.wasteland.enchant.utils

class Validations( val name:String) {

    companion object {
        private val specialCharacters = "!@#$%^&*()-_=+{}[]|:;\"'<>,.?/".toCharArray()

        fun validate(password: String): Result {
            if (password.length < 8) {
                return Result(false, "Password should be at least 8 characters long.")
            }

            if (!password.any { it.isUpperCase() }) {
                return Result(false, "Password should contain at least one uppercase letter.")
            }

            if (!password.any { it.isDigit() }) {
                return Result(false, "Password should contain at least one number.")
            }

            if (!password.any { it in specialCharacters }) {
                return Result(false, "Password should contain at least one special character.")
            }

            return Result(true, "Password is valid.")
        }

    }
}