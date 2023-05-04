import { View, Text } from 'react-native';

import { styles } from './styles';
import { Copyright } from '../Copyright';
import { Option } from '../Option';

import { feedbackTypes } from "../../utils/feedbackTypes"

export function Options() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>
        Deixe seu Feedback
      </Text>

      <View style={styles.options}>
        {
          Object.entries(feedbackTypes).map(([key, value]) => (
            <Option key={key} imageUrl={value.image} title={value.image}/>
          ))
        }
      </View>

      <Copyright />
    </View>
  );
}