import { ChatTeardropDots } from "phosphor-react-native"
import { TouchableOpacity } from "react-native"
import { THEME } from "../../theme"
import { styles } from "./styles"
import BottomSheet from "@gorhom/bottom-sheet"
import { useRef } from "react"
import { gestureHandlerRootHOC } from "react-native-gesture-handler"
import { Options } from "../Options"

function Widget() {
  const bottomSheetRef = useRef<BottomSheet>(null)

  function handleOpen() {
    bottomSheetRef.current?.expand()
  }

  return (
    <>
      <TouchableOpacity style={styles.button} onPress={handleOpen}>
        <ChatTeardropDots size={24} color={THEME.colors.text_on_brand_color} weight="bold" />
      </TouchableOpacity>

      <BottomSheet ref={bottomSheetRef} snapPoints={[1, 280]} backgroundStyle={styles.modal} handleIndicatorStyle={styles.indicator}>
        <Options />
      </BottomSheet>
    </>
  )
}

export default gestureHandlerRootHOC(Widget);
