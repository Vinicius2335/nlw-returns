import { Image, Text, TouchableOpacity, TouchableOpacityProps, ImageSourcePropType } from 'react-native';

import { styles } from './styles';

interface OptionProps extends TouchableOpacityProps {
  title: string;
  image: ImageSourcePropType;
}

export function Option({ title, image, ...rest }: OptionProps) {
  return (
    <TouchableOpacity style={styles.container} {...rest}>
        <Image source={image} style={styles.image}/>
        <Text style={styles.title}>{title}</Text>
    </TouchableOpacity>
  );
}