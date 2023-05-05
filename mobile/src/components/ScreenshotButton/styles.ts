import { StyleSheet } from 'react-native';
import { THEME } from '../../theme';

export const styles = StyleSheet.create({
  container: {
    width: 40,
    height: 40,
    borderRadius: 4,
    backgroundColor: THEME.colors.surface_secondary,
    justifyContent: 'center',
    alignItems: 'center',
    marginRight: 8,
    position: 'relative'
  },

  removeIcon: {
    position: 'absolute',
    bottom: 0,
    right: 0
  },

  image: {
    width: 40,
    height: 40,
  }
  
});