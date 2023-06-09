import { StyleSheet } from 'react-native';
import { THEME } from '../../theme';
import { getBottomSpace } from "react-native-iphone-x-helper"

export const styles = StyleSheet.create({
  button: {
    width: 48,
    height: 48,
    borderRadius: 24,
    backgroundColor: THEME.colors.brand,

    justifyContent: 'center',
    alignItems: 'center',
    position: 'absolute',
    right: 16,
    bottom: getBottomSpace() + 16
  },

  modal: {
    backgroundColor: THEME.colors.surface_primary,
    paddingBottom: getBottomSpace() + 16
  },

  indicator: {
    backgroundColor: THEME.colors.text_primary,
    width: 56,
  },
});