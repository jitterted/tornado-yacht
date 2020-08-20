package com.jitterted.yacht.adapter.ui

import tornadofx.*

class MainView: View() {

  override val root = vbox {
    button("Press me")
    vbox { spacer {  } }
    label("Waiting")
  }
}
