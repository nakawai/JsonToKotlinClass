package wu.seal.jsontokotlin.ui

import com.intellij.util.ui.JBDimension
import wu.seal.jsontokotlin.ConfigManager
import java.awt.BorderLayout
import javax.swing.JPanel

/**
 * others settings tab in config settings dialog
 * Created by Seal.Wu on 2018/2/6.
 */
class AdvancedOtherTab(isDoubleBuffered: Boolean) : JPanel(BorderLayout(), isDoubleBuffered) {
    init {

        jVerticalLinearLayout(true) {

            jCheckBox("Enable Comment", ConfigManager.isCommentOff.not()) {
                addActionListener{
                    ConfigManager.isCommentOff = isSelected.not()
                }
            }
            jCheckBox("Enable Order By Alphabetical",  ConfigManager.isOrderByAlphabetical) {
                addActionListener {
                    ConfigManager.isOrderByAlphabetical = isSelected
                }
            }
            jCheckBox("Enable Inner Class Model", ConfigManager.isInnerClassModel) {
                addActionListener {
                    ConfigManager.isOrderByAlphabetical = isSelected
                }
            }
            jCheckBox("Enable Map Type when JSON Field Key Is Primitive Type", ConfigManager.enableMapType) {
                addActionListener {
                    ConfigManager.enableMapType = isSelected
                }
            }
            jCheckBox("Only create annotations when needed", ConfigManager.enableMinimalAnnotation) {
                addActionListener {
                    ConfigManager.enableMinimalAnnotation = isSelected
                }
            }
            jHorizontalLinearLayout {
                jLabel("Indent (number of space): ")
                jTextInput(ConfigManager.indent.toString()) {
                    columns = 2
                    addFocusLostListener {
                        ConfigManager.indent = try {
                            text.toInt()
                        } catch (e: Exception) {
                            text = ConfigManager.indent.toString()
                            ConfigManager.indent
                        }
                    }
                }
            }

            setAlignLeft(false)

            jHorizontalLinearLayout {
                jLabel("Parent Class Template: ")
                jTextInput(ConfigManager.parenClassTemplate) {
                    addFocusLostListener {
                        ConfigManager.parenClassTemplate = text
                    }
                    maximumSize = JBDimension(400, 30)
                }
            }

        }
    }
}
