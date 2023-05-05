import { View, Text } from "react-native"

import { styles } from "./styles"
import { Copyright } from "../Copyright"
import { Option } from "../Option"

import { feedbackTypes } from "../../utils/feedbackTypes"
import { FeedbackType } from "../Widget"

interface OptionsProps {
  onFeedbackTypeChanged: (feedbackType: FeedbackType) => void
}

export function Options({ onFeedbackTypeChanged }: OptionsProps) {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Deixe seu Feedback</Text>

      <View style={styles.options}>
        {Object.entries(feedbackTypes).map(([key, value]) => (
          <Option
            key={key}
            image={value.image}
            title={value.title}
            onPress={() => onFeedbackTypeChanged(key as FeedbackType)}
          />
        ))}
      </View>

      <Copyright />
    </View>
  )
}
