package com.jitterted.yacht.adapter.ui

import com.jitterted.yacht.domain.Game
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MainView : View() {

    val game = Game()
    val rollProperty = SimpleStringProperty("no roll")

    init {
        game.start()
        rollProperty.value = game.lastRoll().toString()
    }

    override val root =
            vbox {
                hbox {
                    label(rollProperty)
                }
                button("Roll Dice")
            }
}
