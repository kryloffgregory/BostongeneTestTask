package translator


import org.json.simple.JSONArray
import java.net.URL
import org.json.simple.JSONValue
import org.json.simple.JSONObject


const val key = "trnsl.1.1.20190101T152106Z.0318f022e7877826.a5204a4d34e7b25435f86cf72e389870f7318dde"
const val path = "https://translate.yandex.net/api/v1.5/tr.json/translate"
const val lang = "en-ru"


fun translatePhrase(phrase: String) : String {
    val phraseEscaped = phrase.replace(" ", "%20")
    val url = ("$path?key=$key&lang=&lang=$lang&text=$phraseEscaped")
    val response = URL(url).openConnection().getInputStream()
    val resultJson = java.util.Scanner(response).nextLine()
    val jsonObject = JSONValue.parseWithException(resultJson) as JSONObject
    val translatedArray = jsonObject["text"] as JSONArray
    return translatedArray[0] as String
}



fun main(args : Array<String>) {
    println("Enter a phrase to translate")
    val phrase = readLine() as String
    println(translatePhrase(phrase))

}