import { View, TouchableOpacity, TouchableOpacityProps, Image, ImageProps, Text, ImageBackground } from 'react-native';

import { styles } from './styles';

interface OptionProps extends TouchableOpacityProps {
  title: string;
  imageUrl: string; // BUG alterei
}

export function Option({ title, imageUrl, ...rest }: OptionProps) {
  return (
    <TouchableOpacity style={styles.container} {...rest}>
      {/* BUG alterei */}
      {/* BUG Dando erro aki */}
      {/* Video 01:01:48 */}
        <ImageBackground source={{uri: imageUrl}} style={styles.image}/>
        <Text style={styles.title}></Text>
    </TouchableOpacity>
  );
}