package com.jitterted.yacht.adapter.ui

import com.jitterted.yacht.domain.Game
import com.jitterted.yacht.domain.ScoreCategory
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MainView : View() {

    val game = Game()
    val rollProperty = SimpleStringProperty("no roll")
    val scoreProperty = SimpleIntegerProperty(0)

    init {
        game.start()
    }

    override val root =
            hbox {
                vbox {
                    label(scoreProperty)
                }
                vbox {
                    hbox {
                        label(rollProperty)
                    }
                    button("Roll Dice") {
                        action {
                            game.rollDice()
                            rollProperty.value = game.lastRoll().toString()
                        }
                    }
                }
                vbox {
                    button("ONES") {
                        action {
                            game.assignRollTo(ScoreCategory.ONES)
                            scoreProperty.value = game.score()
                        }
                    }
                    button("TWOS")
                    button("THREES")
                }
            }
}
