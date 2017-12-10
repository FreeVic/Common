import android.app.Application

/**
 * Created by Administrator on 2017/12/9.
 */
object CommonApp {
    private lateinit var app:Application
    fun getApplication():Application{
        return app
    }

    fun init(application: Application){
        app = application
    }

    fun getString(resid:Int):String{
        return app.resources.getString(resid)
    }
}