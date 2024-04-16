package com.example.wetherappfull

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
//создаю диалоговое окно если отключен GPS и если делаем поиск по названию города
object DialogManager {
    //диалоговое окно если отключен GPS
    fun locationSettingsDialog(context: Context, listener:Listener){
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Включить местоположение?")
        dialog.setMessage("Местоположение отключено, хотите включить местоположение?")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Хорошо"){_,_ ->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Выйти"){_,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }
    //делаем поиск по названию города
    fun searchByNameDialog(context: Context, listener:Listener){
        val builder = AlertDialog.Builder(context)
        val edName = EditText(context)
        builder.setView(edName)
        val dialog = builder.create()
        dialog.setTitle("Город")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Готово"){_,_ ->
            listener.onClick(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Выйти"){_,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }
    interface Listener{
        fun onClick(name:String?)
    }
}