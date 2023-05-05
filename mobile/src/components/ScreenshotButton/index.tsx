import { View, TouchableOpacity, Image } from "react-native"

import { styles } from "./styles"
import { Camera, Trash } from "phosphor-react-native"
import { THEME } from "../../theme"

interface ScreenshotButtonProps {
  screenshot: string | null
  onTakeShot: () => void
  onRemoveShot: () => void
}

export function ScreenshotButton({ screenshot, onTakeShot, onRemoveShot }: ScreenshotButtonProps) {
  return (
    <TouchableOpacity style={styles.container} onPress={screenshot ? onRemoveShot : onTakeShot}>
      {
        screenshot ? 
        (
          <View>
            <Image style={styles.image} source={{uri: screenshot}} />

            <Trash
              size={22}
              color={THEME.colors.text_secondary}
              weight="fill"
              style={styles.removeIcon}
            />
          </View>
        ) :
        (
          <Camera size={24} color={THEME.colors.text_primary} weight="bold" />
        )
      }
    </TouchableOpacity>
  )
}
