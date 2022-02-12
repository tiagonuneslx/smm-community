package app.smmcommunity.app

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}