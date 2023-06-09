import { ChatTeardropDots } from "phosphor-react-native"
import { TouchableOpacity } from "react-native"
import { THEME } from "../../theme"
import { styles } from "./styles"
import BottomSheet from "@gorhom/bottom-sheet"
import { useRef, useState } from "react"
import { gestureHandlerRootHOC } from "react-native-gesture-handler"
import { Options } from "../Options"
import { feedbackTypes } from "../../utils/feedbackTypes"
import { Form } from "../Form"
import { Success } from "../Success"

export type FeedbackType = keyof typeof feedbackTypes

function Widget() {
  const bottomSheetRef = useRef<BottomSheet>(null)
  const [feedbackType, setFeedbackType] = useState<FeedbackType | null>(null)
  const [feedbackSent, setFeedbackSent] = useState(false)

  function handleOpen() {
    bottomSheetRef.current?.expand()
  }

  function handleFeedbackCancel() {
    setFeedbackType(null)
    setFeedbackSent(false)
  }

  function handleFeedbackSent(){
    setFeedbackSent(true);
  }

  return (
    <>
      <TouchableOpacity style={styles.button} onPress={handleOpen}>
        <ChatTeardropDots size={24} color={THEME.colors.text_on_brand_color} weight="bold" />
      </TouchableOpacity>

      <BottomSheet
        ref={bottomSheetRef}
        snapPoints={[1, 280]}
        backgroundStyle={styles.modal}
        handleIndicatorStyle={styles.indicator}
      >
        {feedbackSent ? (
          <Success onSendAnotherFeedback={handleFeedbackCancel}/>
        ) : (
          <>
            {feedbackType ? (
              <Form
                feedbackType={feedbackType}
                onFeedbackCanceled={handleFeedbackCancel}
                onFeedbackSent={handleFeedbackSent}
              />
            ) : (
              <Options onFeedbackTypeChanged={setFeedbackType} />
            )}
          </>
        )}
      </BottomSheet>
    </>
  )
}

export default gestureHandlerRootHOC(Widget)
