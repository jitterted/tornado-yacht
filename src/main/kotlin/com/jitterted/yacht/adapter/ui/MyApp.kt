package com.jitterted.yacht.adapter.ui

import javafx.application.Application
import tornadofx.*

class MyApp: App(MainView::class)

/**
 * The main method is needed to support the mvn jfx:run goal.
 */
fun main(args: Array<String>) {
  Application.launch(MyApp::class.java, *args)
}