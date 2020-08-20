package com.jitterted.yacht.adapter.ui

import com.jitterted.yacht.domain.Game
import com.jitterted.yacht.domain.ScoreCategory
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
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
                minWidth = 600.0
                minHeight = 400.0
                hbox {
                    label("Score:")
                    label(scoreProperty)
                    padding = Insets(10.0)
                }
                vbox {
                    minWidth = 200.0
                    hbox {
                        padding = Insets(10.0, 0.0, 10.0, 0.0)
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
                    padding = Insets(10.0)
                    button("ONES") {
                        action {
                            game.assignRollTo(ScoreCategory.ONES)
                            scoreProperty.value = game.score()
                        }
                    }
                    button("TWOS")
                    {
                        action {
                            game.assignRollTo(ScoreCategory.TWOS)
                            scoreProperty.value = game.score()
                        }
                    }
                    button("THREES")
                    {
                        action {
                            game.assignRollTo(ScoreCategory.THREES)
                            scoreProperty.value = game.score()
                        }
                    }
                }
            }
}
