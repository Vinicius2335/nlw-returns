import { Inter_400Regular, Inter_500Medium, useFonts } from '@expo-google-fonts/inter';
import "react-native-gesture-handler";
import { StatusBar } from 'expo-status-bar';
import { View } from 'react-native';

import  Widget  from './src/components/Widget';
import { THEME } from './src/theme';
import { Loading } from './src/components/Loading';

export default function App() {
  const [fontsLoaded] = useFonts({
    Inter_400Regular, Inter_500Medium
  })

  return (
    <View
      style={{
        flex: 1,
        backgroundColor: THEME.colors.background
      }}
    >
      <StatusBar style="light" backgroundColor="transparent" translucent />
      
      {fontsLoaded ? <Widget /> : <Loading />}
    </View>
  )
}
