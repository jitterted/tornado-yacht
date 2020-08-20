package com.jitterted.yacht.adapter.ui

import com.jitterted.yacht.domain.Game
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import tornadofx.*

class MainView : View() {

    val game = Game()
    val rollProperty = SimpleStringProperty("no roll")
    val scoreProperty = SimpleIntegerProperty(0)
    val canRollProperty = SimpleBooleanProperty(true)

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
                            canRollProperty.value = game.roundCompleted()
                        }
                        enableWhen(canRollProperty)
                    }
                }
                vbox {
                    padding = Insets(10.0)
                    game.scoredCategories().forEach {
                        button(it.scoreCategory().toString()) {
                            action {
                                game.assignRollTo(it.scoreCategory())
                                scoreProperty.value = game.score()
                                canRollProperty.value = game.roundCompleted()
                                setDisable(true) // cheating, not connected to underlying domain model
                            }
                        }
                    }
                }
            }
}
