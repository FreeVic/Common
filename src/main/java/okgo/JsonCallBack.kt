package okgo

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.lzy.okgo.callback.AbsCallback
import okhttp3.Response
import java.lang.reflect.Type

/**
 * Created by Administrator on 2017/12/9.
 */
abstract class JsonCallBack<T>(): AbsCallback<T>() {
    var type: Type? = null
    var clazz:Class<T>? = null
    constructor(type:Type):this(){
        this.type = type
    }
    constructor(clazz: Class<T>):this(){
        this.clazz = clazz
    }

    override fun convertResponse(response: Response?): T? {
        response?.let {
            val stream = response.body()?.charStream() ?: return null
            val reader = JsonReader(stream)
            type?.let {
                return Gson().fromJson<T>(reader,type)
            }
            clazz?.let {
                return Gson().fromJson<T>(reader,clazz)
            }
        }
        return null
    }

}